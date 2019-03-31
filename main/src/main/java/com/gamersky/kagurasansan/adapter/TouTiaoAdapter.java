package com.gamersky.kagurasansan.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gamersky.kagurasansan.data.bean.ChannelListData;
import com.gamersky.kagurasansan.main.R;
import com.gamersky.kagurasansan.main.databinding.MainItemBannerBinding;
import com.gamersky.kagurasansan.main.databinding.MainItemLoadBinding;
import com.gamersky.kagurasansan.main.databinding.MainItemNewsBinding;
import com.gamersky.kagurasansan.main.databinding.MainItemSantuBinding;
import com.gamersky.kagurasansan.main.databinding.MainItemTuijianyouxiBinding;
import com.gamersky.kagurasansan.main.databinding.MainItemZhuantiBinding;
import com.gamersky.kagurasansan.utils.DateUtils;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther kagurasansan
 * @time 2019/3/29.3:48 PM
 * @des ${TODO}
 */
public class TouTiaoAdapter extends RecyclerView.Adapter {

    private LayoutInflater inflater;
    private static final int HUANDENG = 0;
    private static final int NEWS = 1;
    private static final int SANTU = 2;
    private static final int ZHUANTI = 3;
    private static final int LOAD = 4;
    private static final int TUIJIANYOUXI = 5;
    private Context mContext;

    private boolean hasMore = false;   //是否有更多数据
    private boolean fadeTips = false;  //是否隐藏
    private List<ChannelListData.ResultBean> mData = new ArrayList<>();


    public void setData(List<ChannelListData.ResultBean> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }


    public void addData(List<ChannelListData.ResultBean> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }
    public TouTiaoAdapter(Context context){
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (i) {
            case HUANDENG:
                MainItemBannerBinding itemBannerBinding = DataBindingUtil.inflate(inflater,R.layout.main_item_banner,viewGroup,false);
                viewHolder = new BannerViewHolder(itemBannerBinding);
                break;
            case NEWS:
                MainItemNewsBinding itemNewsBinding = DataBindingUtil.inflate(inflater,R.layout.main_item_news,viewGroup,false);
                viewHolder = new NewsViewHolder(itemNewsBinding);
                break;
            case SANTU:
                MainItemSantuBinding itemSantuBinding = DataBindingUtil.inflate(inflater,R.layout.main_item_santu,viewGroup,false);
                viewHolder = new SanTuViewHolder(itemSantuBinding);
                break;
            case ZHUANTI:
                MainItemZhuantiBinding itemZhuantiBinding = DataBindingUtil.inflate(inflater,R.layout.main_item_zhuanti,viewGroup,false);
                viewHolder = new ZhuanTiViewHolder(itemZhuantiBinding);
                break;
            case LOAD:
                MainItemLoadBinding itemLoadBinding = DataBindingUtil.inflate(inflater,R.layout.main_item_load,viewGroup,false);
                viewHolder = new LoadViewHolder(itemLoadBinding);
                break;
            case TUIJIANYOUXI:
                MainItemTuijianyouxiBinding mainItemTuijianyouxiBinding = DataBindingUtil.inflate(inflater,R.layout.main_item_tuijianyouxi,viewGroup,false);
                viewHolder = new TuiJianViewHolder(mainItemTuijianyouxiBinding);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(getItemViewType(i) == HUANDENG){
            ((BannerViewHolder)viewHolder).onBind(mData.get(i).childElements);
        }else if(getItemViewType(i) == NEWS){
            ((NewsViewHolder)viewHolder).onBind(mData.get(i));
        }else if(getItemViewType(i) == SANTU){
            ((SanTuViewHolder)viewHolder).onBind(mData.get(i));
        }else if(getItemViewType(i) == ZHUANTI){
            ((ZhuanTiViewHolder)viewHolder).onBind(mData.get(i));
        }else if(getItemViewType(i) == TUIJIANYOUXI){
            ((TuiJianViewHolder)viewHolder).onBind(mData.get(i));
        }else if(getItemViewType(i) == LOAD){
            ((LoadViewHolder)viewHolder).onBind();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == getItemCount() - 1){
            return LOAD;
        }else if(mData.get(position).type.equals("huandeng")){
            return HUANDENG;
        }else if(mData.get(position).type.equals("xinwen")){
            return NEWS;
        }else if(mData.get(position).type.equals("santu") ||mData.get(position).type.equals("sanTu")  ){
            return SANTU;
        }else if(mData.get(position).type.equals("zhuanti")){
            return ZHUANTI;
        }else if(mData.get(position).type.equals("tuiJianYouXi")){
            return TUIJIANYOUXI;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return mData.size() + 1;//空数据布局
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder implements OnBannerListener {
            private Context mContext;
            private MainItemBannerBinding root;
            public BannerViewHolder(MainItemBannerBinding itemView) {
                super(itemView.getRoot());
                root = itemView;
            }
            public void onBind(final List<ChannelListData.ResultBean.ChildElementsBean> data){
                root.banner.setImages(createImgGather(data))
                        .setDelayTime(5000)
                        .setBannerStyle(BannerConfig.NOT_INDICATOR)
                        .setImageLoader(new GlideImageLoader())
                        .setOnBannerListener(this)
                        .start();
                root.tvTitle.setText(data.get(0).title);
                root.banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int i, float v, int i1) {

                    }

                    @Override
                    public void onPageSelected(int i) {
                        root.tvTitle.setText(data.get(i).title);
                    }

                    @Override
                    public void onPageScrollStateChanged(int i) {

                    }
                });
            }

            private List<String> createImgGather(List<ChannelListData.ResultBean.ChildElementsBean> data){
                List<String> result = new ArrayList<>();
                for(int i = 0;i < data.size();i++){
                    result.add(data.get(i).thumbnailURLs.get(0));
                }
                return result;
            }

            @Override
            public void OnBannerClick(int position) {

            }
        }


    public class NewsViewHolder extends RecyclerView.ViewHolder{
        private MainItemNewsBinding root;

        public NewsViewHolder(MainItemNewsBinding itemView) {
            super(itemView.getRoot());
            root = itemView;
        }

        public void onBind(ChannelListData.ResultBean data){

            root.tvPushData.setText(DateUtils.longToDate(data.updateTime));
            root.setData(data);
        }

    }

    public class LoadViewHolder extends RecyclerView.ViewHolder{
        private MainItemLoadBinding root;

        public LoadViewHolder(MainItemLoadBinding itemView) {
            super(itemView.getRoot());
            root = itemView;
        }

        public void onBind(){
            if (mData !=null && mData.size() >0 && hasMore) {
                root.pbBar.setVisibility(View.VISIBLE);
                root.tvHint.setVisibility(View.VISIBLE);
                // 不隐藏footView提示
                fadeTips = false;
                if (mData != null && mData.size() > 0) {
                    // 如果查询数据发现增加之后，就显示正在加载更多
                    root.tvHint.setText("加载中...");
                }
            } else {
                if (mData != null && mData.size() > 0) {
                    root.pbBar.setVisibility(View.GONE);
                    root.tvHint.setText("没有更多内容了");
                    // 将fadeTips设置true
                    fadeTips = true;
                    // hasMore设为true是为了让再次拉到底时，会先显示正在加载更多
                    hasMore = false;
                }
            }
        }

    }


    public class SanTuViewHolder extends RecyclerView.ViewHolder{
        private MainItemSantuBinding root;
        public SanTuViewHolder(MainItemSantuBinding itemView) {
            super(itemView.getRoot());
            root = itemView;
        }
        public void onBind(ChannelListData.ResultBean data){
            root.tvPushData.setText(DateUtils.longToDate(data.updateTime));
            root.setData(data);
        }
    }

    public class ZhuanTiViewHolder extends RecyclerView.ViewHolder{
        private MainItemZhuantiBinding root;
        public ZhuanTiViewHolder(MainItemZhuantiBinding itemView) {
            super(itemView.getRoot());
            root = itemView;
        }
        public void onBind(ChannelListData.ResultBean data){
            root.tvPushData.setText(DateUtils.longToDate(data.updateTime));
            root.setData(data);
        }
    }


    public class TuiJianViewHolder extends RecyclerView.ViewHolder{
        private MainItemTuijianyouxiBinding root;

        public TuiJianViewHolder(MainItemTuijianyouxiBinding itemView) {
            super(itemView.getRoot());
            root = itemView;
        }
        public void onBind(ChannelListData.ResultBean data){
            root.setData(data);
        }
    }

    public boolean isFadeTips() {
        return fadeTips;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
        notifyDataSetChanged();
    }

    public boolean hasMoreEnable(){
        if(mData != null && mData.size() > 0){
            return true;
        }else{
            return false;
        }
    }


    //是否正在刷新
    public void setFadeTips(boolean fadeTips) {
        this.fadeTips = fadeTips;
    }
}
