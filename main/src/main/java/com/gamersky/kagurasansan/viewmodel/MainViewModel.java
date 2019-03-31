package com.gamersky.kagurasansan.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.gamersky.kagurasansan.base.base.BaseViewModel;
import com.gamersky.kagurasansan.data.load.MainRepository;
import com.gamersky.kagurasansan.ui.navigator.MainNavigator;

/**
 * @auther kagurasansan
 * @time 2019/3/28.5:55 PM
 * @des ${TODO}
 */
public class MainViewModel extends BaseViewModel<MainRepository,MainNavigator> {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void getMainList(String pageIndex, String elementsCountPerPage){
        mRepository.getMainListData(pageIndex,elementsCountPerPage,getNavigator());
    }

    public void getGameData(int pos,String gameId){
        mRepository.getGameData(pos,gameId,getNavigator());
    }
}
