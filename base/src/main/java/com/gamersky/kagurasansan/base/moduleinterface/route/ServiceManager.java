package com.gamersky.kagurasansan.base.moduleinterface.route;

import com.alibaba.android.arouter.launcher.ARouter;


public class ServiceManager {
    //服务注入看自己的具体实现
    //自动注入

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
