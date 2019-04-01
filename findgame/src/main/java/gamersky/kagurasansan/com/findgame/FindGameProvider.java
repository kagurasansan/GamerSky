package gamersky.kagurasansan.com.findgame;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gamersky.kagurasansan.base.moduleinterface.provider.IFindGameProvider;
import com.gamersky.kagurasansan.base.moduleinterface.route.RouterConstants;


@Route(path = RouterConstants.FIND_GAME_SERVICE)
public class FindGameProvider implements IFindGameProvider {

    private Context context;

    @Override
    public void init(Context context) {
        this.context = context;
    }


    @Override
    public Fragment newInstance(Object... args) {
        return SimpleCardFragment.getInstance("找游戏xxx");
    }
}
