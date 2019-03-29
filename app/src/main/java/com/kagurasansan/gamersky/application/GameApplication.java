package com.kagurasansan.gamersky.application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gamersky.kagurasansan.base.BaseApplication;
import com.gamersky.kagurasansan.base.http.HttpHelper;
import com.gamersky.kagurasansan.base.moduleinterface.config.ModuleOptions;
import com.gamersky.kagurasansan.base.moduleinterface.route.ModuleManager;
import com.gamersky.kagurasansan.base.moduleinterface.route.RouterConstants;
import com.kagurasansan.gamersky.BuildConfig;

/**
 * @auther kagurasansan
 * @time 2019/3/27.5:06 PM
 * @des ${TODO}
 */
public class GameApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
            ARouter.printStackTrace();
        }
        ARouter.init(this);
        HttpHelper.getInstance().init(this);
        ModuleOptions.ModuleBuilder builder = new ModuleOptions.ModuleBuilder(this)
                .addModule(RouterConstants.MAIN_SPLASH, RouterConstants.MAIN_SPLASH)
                .addModule(RouterConstants.ZHIHU, RouterConstants.ZHIHU);
        ModuleManager.getInstance().init(builder.build());
    }
}
