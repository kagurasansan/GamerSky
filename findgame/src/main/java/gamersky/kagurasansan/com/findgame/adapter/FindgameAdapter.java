package gamersky.kagurasansan.com.findgame.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import gamersky.kagurasansan.com.findgame.R;
import gamersky.kagurasansan.com.findgame.data.bean.GameSpecialBean;
import gamersky.kagurasansan.com.findgame.databinding.FindgameItemLunboLayoutBinding;
import gamersky.kagurasansan.com.findgame.databinding.FindgameItemTypeHeadBinding;

/**
 * @auther kagurasansan
 * @time 2019/4/b.9:49 AM
 * @des ${TODO}
 */
public class FindgameAdapter extends RecyclerView.Adapter {

    private static final int HEAD = 0;
    private static final int LUNBO = 1;
    private LayoutInflater inflater;
    private Context mContext;
    private List<GameSpecialBean.ResultBean> gameDatas;

    public void setGameDatas(List<GameSpecialBean.ResultBean> gameDatas) {
        this.gameDatas = gameDatas;
        notifyItemChanged(1);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (i) {
            case HEAD:
                FindgameItemTypeHeadBinding itemTypeHeadBinding = DataBindingUtil.inflate(inflater,R.layout.findgame_item_type_head,viewGroup,false);
                viewHolder = new HeadViewHolder(itemTypeHeadBinding);
                break;
            case LUNBO:
                FindgameItemLunboLayoutBinding itemLunboLayoutBinding = DataBindingUtil.inflate(inflater,R.layout.findgame_item_lunbo_layout,viewGroup,false);
                viewHolder = new LunBoViewHolder(itemLunboLayoutBinding);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case HEAD:
                ((HeadViewHolder)viewHolder).onBind();
                break;
            case LUNBO:
                ((LunBoViewHolder)viewHolder).onBind();
                break;
            default:
                break;
        }
    }
    public FindgameAdapter(Context context){
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }


    public class HeadViewHolder extends RecyclerView.ViewHolder{

        private FindgameItemTypeHeadBinding mFindgameItemTypeHeadBinding;

        public HeadViewHolder(FindgameItemTypeHeadBinding itemView) {
            super(itemView.getRoot());

        }

        public void onBind(){

        }
    }

    public class LunBoViewHolder extends RecyclerView.ViewHolder{
        private FindgameItemLunboLayoutBinding mFindgameItemLunboLayoutBinding;

        public LunBoViewHolder(@NonNull FindgameItemLunboLayoutBinding itemView) {
            super(itemView.getRoot());
            mFindgameItemLunboLayoutBinding = itemView;
        }

        public void onBind(){
            mFindgameItemLunboLayoutBinding.vp.setPageMargin(20);
            mFindgameItemLunboLayoutBinding.vp.setOffscreenPageLimit(3);
            GamePagerAdapter gamePagerAdapter = new GamePagerAdapter(mContext,gameDatas);
            mFindgameItemLunboLayoutBinding.vp.setAdapter(gamePagerAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return HEAD;
        }else if(position == 1){
            return LUNBO;
        }
        return -1;
    }

}
