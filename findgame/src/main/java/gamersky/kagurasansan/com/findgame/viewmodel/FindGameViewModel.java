package gamersky.kagurasansan.com.findgame.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.gamersky.kagurasansan.base.base.BaseViewModel;

import gamersky.kagurasansan.com.findgame.data.load.FindGameRepository;
import gamersky.kagurasansan.com.findgame.ui.FindGameNavigator;

/**
 * @auther kagurasansan
 * @time 2019/4/2.3:55 PM
 * @des ${TODO}
 */
public class FindGameViewModel extends BaseViewModel<FindGameRepository,FindGameNavigator> {

    public FindGameViewModel(@NonNull Application application) {
        super(application);
    }

    public void getGameSpecial(){
        mRepository.getGameSpecial(getNavigator());
    }


}
