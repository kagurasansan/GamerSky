package com.gamersky.kagurasansan.base.moduleinterface.module.main;

import android.support.v4.app.Fragment;

import com.gamersky.kagurasansan.base.moduleinterface.route.ModuleManager;
import com.gamersky.kagurasansan.base.moduleinterface.route.RouterConstants;
import com.gamersky.kagurasansan.base.moduleinterface.route.ServiceManager;


public class MainService {

    private static boolean hasModule() {
        return ModuleManager.getInstance().hasModule(RouterConstants.HOME_MAIN_SERVICE);
    }

    public static Fragment getModule1Frgment(Object... args) {
        if(!hasModule()) return null;
        return ServiceManager.getInstance().getHomeProvider().newInstance(args);
    }
}
