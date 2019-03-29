package com.gamersky.kagurasansan.base.http;

import android.content.Context;
import android.os.Build;

import com.gamersky.kagurasansan.base.BaseApplication;
import com.gamersky.kagurasansan.base.BuildConfig;
import com.gamersky.kagurasansan.base.util.CheckNetwork;
import com.gamersky.kagurasansan.base.util.DeviceUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.gamersky.kagurasansan.base.util.TUtil.checkNotNull;


/**
 * @auther kagurasansan
 * @time 2018/12/10.2:39 PM
 * @des 网络请求框架
 */

public class HttpHelper {

    private static volatile HttpHelper mHttpHelper = null;
    private Context mContext;
    private static Retrofit mRetrofit;

    private final static String BASE_URL = "http://appapi2.gamersky.com/";

    private HttpHelper() {
    }

    public static HttpHelper getInstance(){
        if(mHttpHelper == null){
            synchronized (HttpHelper.class){
                if(mHttpHelper == null){
                    mHttpHelper = new HttpHelper();
                }
            }
        }
        return mHttpHelper;
    }

    public void init(Context context){
        this.mContext = context;
        mRetrofit = getBuilder(BASE_URL).build();
    }

    public Retrofit.Builder getBuilder(String apiUrl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(getOkClient());
        builder.baseUrl(apiUrl);//设置远程地址
        builder.addConverterFactory(GsonConverterFactory.create(getGson()));
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder;
    }

    private Gson getGson() {
        Gson gson;
        GsonBuilder builder = new GsonBuilder();
        builder.setLenient();
        builder.serializeNulls();
        gson = builder.create();
        return gson;
    }

    private OkHttpClient getOkClient() {
        OkHttpClient client;
        client = getUnsafeOkHttpClient();
        return client;
    }

    private OkHttpClient getUnsafeOkHttpClient() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            }};
            // Install the all-trusting trust manager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            //cache url
            File httpCacheDirectory = new File(mContext.getCacheDir(), "responses");
            // 50 MiB
            int cacheSize = 50 * 1024 * 1024;
            Cache cache = new Cache(httpCacheDirectory, cacheSize);
            // Create an ssl socket factory with our all-trusting manager
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
            okBuilder.readTimeout(30, TimeUnit.SECONDS);
            okBuilder.connectTimeout(30, TimeUnit.SECONDS);
            okBuilder.writeTimeout(30, TimeUnit.SECONDS);
            okBuilder.addInterceptor(new HttpHeadInterceptor());
            // 添加缓存，无网访问时会拿缓存,只会缓存get请求
            okBuilder.addInterceptor(new RequestCommonInteIntercept(mContext));
            okBuilder.addInterceptor(new AddCacheInterceptor(mContext));
            okBuilder.cache(cache);
            okBuilder.addInterceptor(getInterceptor());
            okBuilder.sslSocketFactory(sslSocketFactory);
            return okBuilder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private class HttpHeadInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            builder.addHeader("Accept", "application/json;versions=1");
            if (CheckNetwork.isNetworkConnected(mContext)) {
                int maxAge = 60;
                builder.addHeader("Cache-Control", "public, max-age=" + maxAge);
            } else {
                int maxStale = 60 * 60 * 24 * 28;
                builder.addHeader("Cache-Control", "public, only-if-cached, max-stale=" + maxStale);
            }
            return chain.proceed(builder.build());
        }
    }

    private HttpLoggingInterceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return interceptor;
    }

    private class AddCacheInterceptor implements Interceptor {
        private Context context;

        AddCacheInterceptor(Context context) {
            super();
            this.context = context;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            cacheBuilder.maxStale(365, TimeUnit.DAYS);
            CacheControl cacheControl = cacheBuilder.build();
            Request request = chain.request();
            if (!CheckNetwork.isNetworkConnected(context)) {
                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (CheckNetwork.isNetworkConnected(context)) {
                // read from cache
                int maxAge = 0;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                // tolerate 4-weeks stale
                int maxStale = 60 * 60 * 24 * 28;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    }

    private class RequestCommonInteIntercept implements Interceptor{
        private Context context;
        RequestCommonInteIntercept(Context context) {
            super();
            this.context = context;

        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder requestBuilder = request.newBuilder();
            //添加公共的头部
            String method = request.method();
            //接口规则规定了请求方式为 Form 表单，这里只对Post进行处理
            if ("POST".equals(method)) {  //POST 请求
                RequestBody body = request.body();
                FormBody formBody = (FormBody) body;
                //由于采用的是 普通的@Post 形式
                //并且经过Converter 的转换，内容为Json字符串
                //这里直接进行读取
                int size = formBody.size();
                //循环将传入的 表单添加到新的表单
                JSONObject json = new JSONObject();
                for (int i = 0; i < size; i++) {
                    String name = formBody.name(i);
                    String value = formBody.value(i);
                    try {
                        json.put(name, value);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                JSONObject map = new JSONObject();
                try {
                    map.put("request",json);
                    map.put("os","android");
                    map.put("app","GSAPP");
                    map.put("osVersion", String.valueOf(android.os.Build.VERSION.SDK_INT));
                    map.put("deviceType", String.valueOf(Build.MODEL));
                    map.put("appVersion", "4.8.2");
                    map.put("deviceId", DeviceUtils.getDeviceId(BaseApplication.getBaseApplication()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                request = requestBuilder
                        .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), map.toString()))
                        .build();
            }
            return chain.proceed(request);
        }
    }


    public <T> T create(Class<T> clz) {
        checkNotNull(clz);
        checkNotNull(mRetrofit);
        return mRetrofit.create(clz);
    }
}
