package com.gamersky.kagurasansan.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.gamersky.kagurasansan.base.base.BaseActivity;
import com.gamersky.kagurasansan.base.moduleinterface.route.RouterConstants;
import com.gamersky.kagurasansan.main.databinding.MainActivityMainBinding;

import java.util.ArrayList;

@Route(path = RouterConstants.MAIN_HOME)
public class MainActivity extends BaseActivity<MainActivityMainBinding> {

    private String[] mTitles = {"首页", "找游戏", "查攻略", "圈子","我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.icon_xinwen, R.mipmap.icon_youxi,
            R.mipmap.icon_strategy, R.mipmap.ic_main_quanzi_default,R.mipmap.icon_yonghu};
    private int[] mIconSelectIds = {
            R.mipmap.icon_xinwen_select, R.mipmap.icon_youxi_select,
            R.mipmap.icon_strategy_select, R.mipmap.ic_main_quanzi_selected,R.mipmap.icon_yonghu_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
        showContentView();
        setAndroidNativeLightStatusBar(this,true);
        initBottomIcon();
    }

    private void initBottomIcon() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
            if(i == 0){
                mFragments.add(MainFragment.getInstance());
            }else{
                mFragments.add(SimpleCardFragment.getInstance(mTitles[i]));
            }

        }

        bindingView.tablayout.setTabData(mTabEntities,this,R.id.fl_container,mFragments);

    }
}
