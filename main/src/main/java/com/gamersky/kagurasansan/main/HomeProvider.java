package com.gamersky.kagurasansan.main;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gamersky.kagurasansan.base.moduleinterface.provider.IHomeProvider;
import com.gamersky.kagurasansan.base.moduleinterface.route.RouterConstants;


@Route(path = RouterConstants.HOME_MAIN_SERVICE)
public class HomeProvider implements IHomeProvider {

    private Context context;

    @Override
    public void init(Context context) {
        this.context = context;
    }


    @Override
    public Fragment newInstance(Object... args) {
        return MainFragment.getInstance();
    }
}
