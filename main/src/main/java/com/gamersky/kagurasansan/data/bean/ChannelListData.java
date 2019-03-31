package com.gamersky.kagurasansan.data.bean;

import com.gamersky.kagurasansan.base.data.DataBaseBean;

import java.util.List;

/**
 * @auther kagurasansan
 * @time 2019/3/28.5:43 PM
 * @des ${TODO}
 */
public class ChannelListData extends DataBaseBean {


    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * type : huandeng
         * contentType : huandeng
         * contentId : 0
         * title : 幻灯
         * description : null
         * thumbnailURLs : null
         * authorName : null
         * authorHeadImageURL : null
         * badges : null
         * readingCount : 0
         * commentsCount : 0
         * contentURL : null
         * adId : 0
         * updateTime : 0
         * duration : null
         * sourceName : null
         * childElements : [{"type":"huandeng","contentType":"news","contentId":1168082,"title":"《无主之地3》正式公布！首部预告公开","description":null,"thumbnailURLs":["https://image.gamersky.com/gameshd/2019/20190329_lxy_357_4.jpg"],"authorName":"","authorHeadImageURL":"","badges":[],"readingCount":2828,"commentsCount":0,"contentURL":"","adId":0,"dataPackage":false,"updateTime":1.553827706E12,"childElements":null},{"type":"huandeng","contentType":"news","contentId":1168096,"title":"《复联4》内地正式定档4月24日 新海报亮了","description":null,"thumbnailURLs":["https://image.gamersky.com/gameshd/2019/20190329_lxy_357_3.jpg"],"authorName":"","authorHeadImageURL":"","badges":[],"readingCount":0,"commentsCount":0,"contentURL":"","adId":0,"dataPackage":false,"updateTime":1.553827657E12,"childElements":null},{"type":"huandeng","contentType":"yuanChuang","contentId":1157034,"title":"各国如何处理抗命者和逃兵？","description":null,"thumbnailURLs":["https://imgs.gamersky.com/pic/2019/20190228xtn_162_5.jpg"],"authorName":"","authorHeadImageURL":"","badges":[],"readingCount":0,"commentsCount":0,"contentURL":"","adId":0,"dataPackage":false,"updateTime":1.553776508E12,"childElements":null},{"type":"huandeng","contentType":"news","contentId":1168051,"title":"虽然抽烟喝酒染头 但是个好女孩儿的囧图","description":null,"thumbnailURLs":["https://image.gamersky.com/gameshd/2019/20190328_zy_124_13.jpg"],"authorName":"","authorHeadImageURL":"","badges":[],"readingCount":0,"commentsCount":0,"contentURL":"","adId":0,"dataPackage":false,"updateTime":1.553769535E12,"childElements":null},{"type":"huandeng","contentType":"news","contentId":1167674,"title":"《神界》新作公布！同一世界观 今年登多平台","description":null,"thumbnailURLs":["https://image.gamersky.com/gameshd/2019/20190328_gtz_red_412_8.jpg"],"authorName":"","authorHeadImageURL":"","badges":[],"readingCount":0,"commentsCount":0,"contentURL":"","adId":0,"dataPackage":false,"updateTime":1.553756574E12,"childElements":null},{"type":"huandeng","contentType":"news","contentId":1167538,"title":"生化2、鬼泣5爆红 动作天尊卡普空回来了？","description":null,"thumbnailURLs":["https://imgs.gamersky.com/pic/2019/20190327xtn_162_4.jpg"],"authorName":"","authorHeadImageURL":"","badges":[],"readingCount":53,"commentsCount":0,"contentURL":"","adId":0,"dataPackage":false,"updateTime":1.553690381E12,"childElements":null}]
         */

        public String type;
        public String contentType;
        public long contentId;
        public String title;
        public String description;
        public List<String> thumbnailURLs;
        public Object authorName;
        public Object authorHeadImageURL;
        public Object badges;
        public int readingCount;
        public int commentsCount;
        public Object contentURL;
        public int adId;
        public long updateTime;
        public Object duration;
        public Object sourceName;
        public List<ChildElementsBean> childElements;

        public static class ChildElementsBean {
            /**
             * type : huandeng
             * contentType : news
             * contentId : 1168082
             * title : 《无主之地3》正式公布！首部预告公开
             * description : null
             * thumbnailURLs : ["https://image.gamersky.com/gameshd/2019/20190329_lxy_357_4.jpg"]
             * authorName :
             * authorHeadImageURL :
             * badges : []
             * readingCount : 2828
             * commentsCount : 0
             * contentURL :
             * adId : 0
             * dataPackage : false
             * updateTime : 1.553827706E12
             * childElements : null
             */

            public String type;
            public String contentType;
            public int contentId;
            public String title;
            public Object description;
            public String authorName;
            public String authorHeadImageURL;
            public int readingCount;
            public int commentsCount;
            public String contentURL;
            public int adId;
            public boolean dataPackage;
            public double updateTime;
            public Object childElements;
            public List<String> thumbnailURLs;
            public List<?> badges;
        }
    }
}
