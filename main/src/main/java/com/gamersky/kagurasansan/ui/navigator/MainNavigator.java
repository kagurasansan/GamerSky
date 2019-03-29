package com.gamersky.kagurasansan.ui.navigator;

import com.gamersky.kagurasansan.base.base.BaseNavigator;
import com.gamersky.kagurasansan.data.bean.ChannelListData;

/**
 * @auther kagurasansan
 * @time 2019/3/29.1:52 PM
 * @des ${TODO}
 */
public interface MainNavigator extends BaseNavigator {

    void onSuccess(ChannelListData dataBean);
}
