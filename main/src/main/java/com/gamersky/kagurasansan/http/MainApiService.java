package com.gamersky.kagurasansan.http;

import com.gamersky.kagurasansan.data.bean.ChannelListData;
import com.gamersky.kagurasansan.data.bean.GameInfoBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @auther kagurasansan
 * @time 2019/3/29.11:03 AM
 * @des ${TODO}
 */
public interface MainApiService {

    @FormUrlEncoded
    @POST("v2/AllChannelList")
    Flowable<ChannelListData> getUserBalance(@Field("nodeIds") String nodeIds,
                                             @Field("pageIndex") String pageIndex,
                                             @Field("elementsCountPerPage") String elementsCountPerPage,
                                             @Field("parentNodeId") String parentNodeId,
                                             @Field("type") String type);
    @FormUrlEncoded
    @POST("v4/getGame")
    Flowable<GameInfoBean> getGameData(@Field("gameId") String gameId,
                                       @Field("gameModeFieldNames") String gameModeFieldNames,
                                       @Field("gameRelatedFieldNames")String gameRelatedFieldNames,
                                       @Field("gameTagsCount") int gameTagsCount);

}
