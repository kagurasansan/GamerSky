package com.gamersky.kagurasansan.base.moduleinterface.provider;

import android.support.v4.app.Fragment;

/**
 * @auther kagurasansan
 * @time 2019/4/1.4:23 PM
 * @des ${TODO}
 */
public interface IFindGameProvider extends BaseProvider{
    Fragment newInstance(Object... args);
}
