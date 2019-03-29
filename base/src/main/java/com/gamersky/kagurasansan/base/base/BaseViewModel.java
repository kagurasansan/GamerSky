package com.gamersky.kagurasansan.base.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.gamersky.kagurasansan.base.util.TUtil;

import java.lang.ref.WeakReference;


public class BaseViewModel<T extends AbsRepository,N> extends AndroidViewModel {

    protected T mRepository;

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    private WeakReference<N> mNavigator;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mRepository = TUtil.getNewInstance(this, 0);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mRepository != null) {
            mRepository.unDisposable();
        }
    }
}
