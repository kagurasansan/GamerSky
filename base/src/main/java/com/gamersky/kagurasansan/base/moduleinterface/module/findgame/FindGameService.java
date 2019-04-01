package com.gamersky.kagurasansan.base.moduleinterface.module.findgame;

import android.support.v4.app.Fragment;

import com.gamersky.kagurasansan.base.moduleinterface.route.ModuleManager;
import com.gamersky.kagurasansan.base.moduleinterface.route.RouterConstants;
import com.gamersky.kagurasansan.base.moduleinterface.route.ServiceManager;

/**
 * @auther kagurasansan
 * @time 2019/4/1.4:29 PM
 * @des ${TODO}
 */
public class FindGameService {

    private static boolean hasModule() {
        return ModuleManager.getInstance().hasModule(RouterConstants.FIND_GAME_SERVICE);
    }

    public static Fragment getFindGameFrgment(Object... args) {
        if(!hasModule()) return null;
        return ServiceManager.getInstance().getFindProvider().newInstance(args);
    }
}
