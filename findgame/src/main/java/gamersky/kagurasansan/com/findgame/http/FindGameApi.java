package gamersky.kagurasansan.com.findgame.http;

import gamersky.kagurasansan.com.findgame.data.bean.GameSpecialBean;
import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @auther kagurasansan
 * @time 2019/4/2.3:46 PM
 * @des ${TODO}
 */
public interface FindGameApi {

    @FormUrlEncoded
    @POST("game/gameSpecialDetail")
    Flowable<GameSpecialBean> getGameSpecial(@Field("extraField1") String extraField1,
                                             @Field("pageIndex") int pageIndex,
                                             @Field("elementsCountPerPage") int elementsCountPerPage,
                                             @Field("nodeId") String nodeId,
                                             @Field("extraField2") String extraField2,
                                             @Field("extraField3") String extraField3);


}
