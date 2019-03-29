package com.gamersky.kagurasansan.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gamersky.kagurasansan.data.bean.ChannelListData;
import com.gamersky.kagurasansan.main.R;
import com.gamersky.kagurasansan.main.databinding.MainItemBannerBinding;
import com.gamersky.kagurasansan.main.databinding.MainItemNewsBinding;
import com.gamersky.kagurasansan.main.databinding.MainItemSantuBinding;
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

    private List<ChannelListData.ResultBean> data;
    private LayoutInflater inflater;
    private static final int HUANDENG = 0;
    private static final int NEWS = 1;
    private static final int SANTU = 2;
    private Context mContext;

    public void setData(List<ChannelListData.ResultBean> data) {
        this.data = data;
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
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(getItemViewType(i) == HUANDENG){
            ((BannerViewHolder)viewHolder).onBind(data.get(i).childElements);
        }else if(getItemViewType(i) == NEWS){
            ((NewsViewHolder)viewHolder).onBind(data.get(i));
        }else if(getItemViewType(i) == SANTU){
            ((SanTuViewHolder)viewHolder).onBind(data.get(i));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(data.get(position).type.equals("huandeng")){
            return HUANDENG;
        }else if(data.get(position).type.equals("xinwen")){
            return NEWS;
        }else if(data.get(position).type.equals("santu")){
            return SANTU;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return data.size();
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
}
