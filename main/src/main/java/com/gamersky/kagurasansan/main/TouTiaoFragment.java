package com.gamersky.kagurasansan.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.gamersky.kagurasansan.adapter.TouTiaoAdapter;
import com.gamersky.kagurasansan.base.base.BaseFragment;
import com.gamersky.kagurasansan.data.bean.ChannelListData;
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
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.setNavigator(this);

        mMainViewModel.getMainList("1","20");
        mTouTiaoAdapter = new TouTiaoAdapter(getContext());
        bindingView.rcData.setLayoutManager(new LinearLayoutManager(getContext()));
        bindingView.sr.setOnRefreshListener(this);
        //设置圆圈进度条的背景颜色
        bindingView.sr.setColorSchemeResources(R.color.main_red);
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
        bindingView.rcData.setAdapter(mTouTiaoAdapter);
        mTouTiaoAdapter.setData(dataBean.result);
    }

    @Override
    public void onNoNetWork() {
        bindingView.sr.setRefreshing(false);
        Toast.makeText(getActivity(), "当前网络状态不好", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        mMainViewModel.getMainList("1","20");
    }
}
