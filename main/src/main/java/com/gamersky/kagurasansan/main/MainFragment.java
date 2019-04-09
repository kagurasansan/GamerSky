package com.gamersky.kagurasansan.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gamersky.kagurasansan.base.base.BaseFragment;
import com.gamersky.kagurasansan.main.databinding.MainFragmentMainBinding;

import java.util.ArrayList;

/**
 * @auther kagurasansan
 * @time 2019/3/28.4:16 PM
 * @des ${TODO}
 */
public class MainFragment extends BaseFragment<MainFragmentMainBinding> {

    private final String[] mTitles = {
            "订阅", "头条", "热门"
            , "游戏", "科技", "影视", "硬件","动漫","娱乐","手游","视频"
    };
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyPagerAdapter mAdapter;


    public static MainFragment getInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        for (int i  = 0;i < mTitles.length;i ++) {
            if(i == 1){
                mFragments.add(TouTiaoFragment.getInstance("0",true));
            }else if(i == 3){
                mFragments.add(TouTiaoFragment.getInstance("16",false));
            }else if(i == 4){
                mFragments.add(TouTiaoFragment.getInstance("19",false));
            }else if(i == 5){
                mFragments.add(TouTiaoFragment.getInstance("30",false));
            }else if(i == 6){
                mFragments.add(TouTiaoFragment.getInstance("4",false));
            }else if(i == 7){
                mFragments.add(TouTiaoFragment.getInstance("31",false));
            }else if(i == 8){
                mFragments.add(TouTiaoFragment.getInstance("32",false));
            }else if(i == 9){
                mFragments.add(TouTiaoFragment.getInstance("33",false));
            }else{
                mFragments.add(SimpleCardFragment.getInstance(mTitles[i]));
            }
        }
        mAdapter = new MyPagerAdapter(getFragmentManager());
        bindingView.vp.setAdapter(mAdapter);
        bindingView.tablayout.setViewPager(bindingView.vp, mTitles, getActivity(), mFragments);


    }

    @Override
    public int setContent() {
        return R.layout.main_fragment_main;
    }



    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
