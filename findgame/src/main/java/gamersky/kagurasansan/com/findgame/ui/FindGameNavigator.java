package gamersky.kagurasansan.com.findgame.ui;

import com.gamersky.kagurasansan.base.base.BaseNavigator;

import gamersky.kagurasansan.com.findgame.data.bean.GameSpecialBean;

/**
 * @auther kagurasansan
 * @time 2019/4/2.3:55 PM
 * @des ${TODO}
 */
public interface FindGameNavigator extends BaseNavigator {
    void onSuccess(GameSpecialBean dataBean);
}

