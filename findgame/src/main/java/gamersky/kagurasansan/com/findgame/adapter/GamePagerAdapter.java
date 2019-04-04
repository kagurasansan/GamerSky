package gamersky.kagurasansan.com.findgame.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.gamersky.kagurasansan.base.util.DensityUtils;

import java.util.ArrayList;
import java.util.List;

import gamersky.kagurasansan.com.findgame.R;
import gamersky.kagurasansan.com.findgame.data.bean.GameSpecialBean;

/**
 * @auther kagurasansan
 * @time 2019/4/2.3:25 PM
 * @des ${TODO}
 */
public class GamePagerAdapter extends PagerAdapter {

    private List<GameSpecialBean.ResultBean> data;

    private LayoutInflater inflater;
    private Context mContext;
    private List<View> viewList;

    public GamePagerAdapter(Context context, List<GameSpecialBean.ResultBean> data) {
        mContext = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        View view;
        if(data != null){
            for(int i = 0;i < data.size();i ++){
                view = inflater.inflate(R.layout.findgame_item_lunbo, null);
                ImageView imageView = view.findViewById(R.id.iv_game_pic);
                TextView tvTitle = view.findViewById(R.id.tv_title);
                tvTitle.setText(data.get(i).Title);
                TextView tvCount = view.findViewById(R.id.tv_count);
                tvCount.setText(String.format(context.getString(R.string.findgame_countstar), data.get(i).gsScore));
                TextView tvDes = view.findViewById(R.id.tv_des);
                tvDes.setText(data.get(i).description);
                Glide.with(context).load(data.get(i).largeImage)
                        .apply(RequestOptions.bitmapTransform( new RoundedCorners(DensityUtils.dp2px(mContext,10))))
                        .into(imageView);
                viewList.add(view);
            }
        }

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return data != null ? data.size(): 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }
}
