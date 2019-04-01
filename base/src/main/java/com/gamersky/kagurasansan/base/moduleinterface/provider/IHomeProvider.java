package com.gamersky.kagurasansan.base.moduleinterface.provider;

import android.support.v4.app.Fragment;

public interface IHomeProvider extends BaseProvider {
    Fragment newInstance(Object... args);
}
