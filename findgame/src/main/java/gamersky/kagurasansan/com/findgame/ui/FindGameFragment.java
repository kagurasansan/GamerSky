package gamersky.kagurasansan.com.findgame.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.gamersky.kagurasansan.base.base.BaseFragment;

import gamersky.kagurasansan.com.findgame.R;
import gamersky.kagurasansan.com.findgame.adapter.FindgameAdapter;
import gamersky.kagurasansan.com.findgame.data.bean.GameSpecialBean;
import gamersky.kagurasansan.com.findgame.databinding.FindgameFragmentFindgameBinding;
import gamersky.kagurasansan.com.findgame.viewmodel.FindGameViewModel;

/**
 * @auther kagurasansan
 * @time 2019/4/b.9:38 AM
 * @des ${TODO}
 */
public class FindGameFragment extends BaseFragment<FindgameFragmentFindgameBinding> implements FindGameNavigator {

    private FindgameAdapter mFindgameAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private FindGameViewModel mFindGameViewModel;

    @Override
    public int setContent() {
        return R.layout.findgame_fragment_findgame;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        bindingView.rcData.setLayoutManager(mLinearLayoutManager);
        mFindgameAdapter = new FindgameAdapter(getContext());
        bindingView.rcData.setAdapter(mFindgameAdapter);

        mFindGameViewModel = ViewModelProviders.of(this).get(FindGameViewModel.class);
        mFindGameViewModel.setNavigator(this);

        mFindGameViewModel.getGameSpecial();
    }

    public static FindGameFragment getInstance() {
        FindGameFragment sf = new FindGameFragment();
        return sf;
    }

    @Override
    public void onNoNetWork() {

    }

    @Override
    public void onSuccess(GameSpecialBean dataBean) {
        mFindgameAdapter.setGameDatas(dataBean.result);
    }
}
