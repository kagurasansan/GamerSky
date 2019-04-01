package com.gamersky.kagurasansan.base.moduleinterface.route;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gamersky.kagurasansan.base.moduleinterface.provider.IFindGameProvider;
import com.gamersky.kagurasansan.base.moduleinterface.provider.IHomeProvider;


public class ServiceManager {

    @Autowired
    IHomeProvider homeProvider;

    IFindGameProvider mIFindGameProvider;

    public IHomeProvider getHomeProvider() {
        return homeProvider;
    }

    public IFindGameProvider getFindProvider() {
        return  mIFindGameProvider != null ? mIFindGameProvider : (mIFindGameProvider = ((IFindGameProvider) MyRouter.newInstance(RouterConstants.FIND_GAME_SERVICE).navigation()));
    }

    public ServiceManager() {
        ARouter.getInstance().inject(this);
    }

    private static final class ServiceManagerHolder {
        private static final ServiceManager instance = new ServiceManager();
    }

    public static ServiceManager getInstance() {
        return ServiceManagerHolder.instance;
    }


}
