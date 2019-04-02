package gamersky.kagurasansan.com.findgame.data.bean;

import com.gamersky.kagurasansan.base.data.DataBaseBean;

import java.util.List;

/**
 * @auther kagurasansan
 * @time 2019/4/2.3:31 PM
 * @des ${TODO}
 */
public class GameSpecialBean extends DataBaseBean {

    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * Id : 911313
         * subgroup : 新游推荐
         * Title : 海岛大亨6
         * DefaultPicUrl : https://imgs.gamersky.com/ku/2017/ku_tropico6.jpg
         * Position :
         * Subheading :
         * gsScore : 8.7
         * largeImage : https://image.gamersky.com/gameshd/2019/20190402_lhj_437_1.jpg
         * description : 虽然没中文 游戏还是老味道 别妄想代理了
         by玩家 SoX~|TaNk
         */

        public int Id;
        public String subgroup;
        public String Title;
        public String DefaultPicUrl;
        public String Position;
        public String Subheading;
        public String gsScore;
        public String largeImage;
        public String description;
    }
}
