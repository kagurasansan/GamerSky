package com.gamersky.kagurasansan.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.gamersky.kagurasansan.adapter.TouTiaoAdapter;
import com.gamersky.kagurasansan.base.base.BaseFragment;
import com.gamersky.kagurasansan.data.bean.ChannelListData;
import com.gamersky.kagurasansan.data.bean.GameInfoBean;
import com.gamersky.kagurasansan.main.databinding.MainFragmentToutiaoBinding;
import com.gamersky.kagurasansan.ui.navigator.MainNavigator;
import com.gamersky.kagurasansan.viewmodel.MainViewModel;

/**
 * @auther kagurasansan
 * @time 2019/3/29.3:37 PM
 * @des ${TODO}
 */
public class TouTiaoFragment extends BaseFragment<MainFragmentToutiaoBinding> implements MainNavigator,SwipeRefreshLayout.OnRefreshListener{

    private MainViewModel mMainViewModel;
    private TouTiaoAdapter mTouTiaoAdapter;
    private int lastVisibleItem = 0;
    private LinearLayoutManager mLinearLayoutManager;
    private int mPage = 1;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.setNavigator(this);

        mMainViewModel.getMainList(String.valueOf(mPage),"20");
        mTouTiaoAdapter = new TouTiaoAdapter(getContext());
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        bindingView.rcData.setLayoutManager(mLinearLayoutManager);
        bindingView.rcData.setAdapter(mTouTiaoAdapter);
        bindingView.sr.setOnRefreshListener(this);
        //设置圆圈进度条的背景颜色
        bindingView.sr.setColorSchemeResources(R.color.main_red);
        bindingView.rcData.setItemAnimator(null);
        bindingView.rcData.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if(!mTouTiaoAdapter.isFadeTips() && lastVisibleItem + 1 == mTouTiaoAdapter.getItemCount() && mTouTiaoAdapter.hasMoreEnable()) {
                        mTouTiaoAdapter.setFadeTips(true);  //表示正在刷新
                        mMainViewModel.getMainList(String.valueOf(mPage),"20");
                    }
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
            }
        });
        mTouTiaoAdapter.setGetGameInterface(new TouTiaoAdapter.getGameInterface() {
            @Override
            public void getGameData(int pos,String gameId) {
                mMainViewModel.getGameData(pos,gameId);
            }
        });
    }

    public static TouTiaoFragment getInstance() {
        TouTiaoFragment sf = new TouTiaoFragment();
        return sf;
    }

    @Override
    public int setContent() {
        return R.layout.main_fragment_toutiao;
    }

    @Override
    public void onSuccess(ChannelListData dataBean) {
        bindingView.sr.setRefreshing(false);
        if(dataBean != null && dataBean.result != null && dataBean.result.size() > 0){
            mTouTiaoAdapter.setHasMore(true);
            mTouTiaoAdapter.setFadeTips(false);
            if(mPage == 1){ mTouTiaoAdapter.setData(dataBean.result);
            }else{
                mTouTiaoAdapter.addData(dataBean.result);
            }
        }else{
            mTouTiaoAdapter.setHasMore(false);
            mTouTiaoAdapter.setFadeTips(false);
        }
        mPage ++;
    }

    @Override
    public void onGameSuccess(int pos,GameInfoBean dataBean) {
        mTouTiaoAdapter.setItemData(pos,dataBean);
    }

    @Override
    public void onNoNetWork() {
        bindingView.sr.setRefreshing(false);
        Toast.makeText(getActivity(), "当前网络状态不好", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        mPage = 1;
        mMainViewModel.getMainList(String.valueOf(mPage),"20");
    }
}
