package com.gamersky.kagurasansan.data.load;

import com.gamersky.kagurasansan.base.base.AbsRepository;
import com.gamersky.kagurasansan.base.http.HttpHelper;
import com.gamersky.kagurasansan.base.http.rx.RxSchedulers;
import com.gamersky.kagurasansan.base.http.rx.RxSubscriber;
import com.gamersky.kagurasansan.base.moduleinterface.route.RouterConstants;
import com.gamersky.kagurasansan.data.bean.ChannelListData;
import com.gamersky.kagurasansan.data.bean.GameInfoBean;
import com.gamersky.kagurasansan.http.MainApiService;
import com.gamersky.kagurasansan.ui.navigator.MainNavigator;

/**
 * @auther kagurasansan
 * @time 2019/3/28.5:56 PM
 * @des ${TODO}
 */
public class MainRepository extends AbsRepository {
    private MainApiService mMainApiService;

    public MainRepository() {
        mMainApiService = HttpHelper.getInstance().create(MainApiService.class);
    }

    public void getMainListData(String nodeIds,String pageIndex, String elementsCountPerPage, final MainNavigator mainNavigator){
        addDisposable(mMainApiService.getUserBalance(nodeIds,pageIndex,elementsCountPerPage,"news","")
                .compose(new RxSchedulers<ChannelListData>().io_main())
                .subscribeWith(new RxSubscriber<ChannelListData>( ){
                    @Override
                    protected void onNoNetWork() {
                        super.onNoNetWork();
                        mainNavigator.onNoNetWork();
                    }

                    @Override
                    public void onSuccess(ChannelListData dataBean) {
                        mainNavigator.onSuccess(dataBean);
                    }

                    @Override
                    public void onFailure(int code,String msg) {

                    }
                }));
    }

    public void getGameData(final int pos, String gameId, final MainNavigator mainNavigator){
        addDisposable(mMainApiService.getGameData(gameId,RouterConstants.GAMEMODEFIELDNAMES,RouterConstants.GAMERELATEDFIELDNAMES,20)
                .compose(new RxSchedulers<GameInfoBean>().io_main())
                .subscribeWith(new RxSubscriber<GameInfoBean>( ){
                    @Override
                    protected void onNoNetWork() {
                        super.onNoNetWork();
                        mainNavigator.onNoNetWork();
                    }

                    @Override
                    public void onSuccess(GameInfoBean dataBean) {
                        mainNavigator.onGameSuccess(pos,dataBean);
                    }

                    @Override
                    public void onFailure(int code,String msg) {

                    }
                }));
    }
}
