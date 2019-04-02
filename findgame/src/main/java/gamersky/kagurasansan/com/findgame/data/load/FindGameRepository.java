package gamersky.kagurasansan.com.findgame.data.load;

import com.gamersky.kagurasansan.base.base.AbsRepository;
import com.gamersky.kagurasansan.base.http.HttpHelper;
import com.gamersky.kagurasansan.base.http.rx.RxSchedulers;
import com.gamersky.kagurasansan.base.http.rx.RxSubscriber;

import gamersky.kagurasansan.com.findgame.data.bean.GameSpecialBean;
import gamersky.kagurasansan.com.findgame.http.FindGameApi;
import gamersky.kagurasansan.com.findgame.ui.FindGameNavigator;

/**
 * @auther kagurasansan
 * @time 2019/4/2.3:49 PM
 * @des ${TODO}
 */
public class FindGameRepository extends AbsRepository {
    private FindGameApi mFindGameApi;

    public FindGameRepository() {
        mFindGameApi = HttpHelper.getInstance().create(FindGameApi.class);
    }

    public void getGameSpecial(final FindGameNavigator findGameNavigator){
        addDisposable(mFindGameApi.getGameSpecial("Position,Subheading",1,10,
                "13","gsScore","largeImage,description")
                .compose(new RxSchedulers<GameSpecialBean>().io_main())
                .subscribeWith(new RxSubscriber<GameSpecialBean>( ){
                    @Override
                    protected void onNoNetWork() {
                        super.onNoNetWork();
                        findGameNavigator.onNoNetWork();
                    }

                    @Override
                    public void onSuccess(GameSpecialBean dataBean) {
                        findGameNavigator.onSuccess(dataBean);
                    }

                    @Override
                    public void onFailure(int code,String msg) {

                    }
                }));
    }


}
