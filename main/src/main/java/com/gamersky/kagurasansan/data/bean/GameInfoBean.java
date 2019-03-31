package com.gamersky.kagurasansan.data.bean;

import com.gamersky.kagurasansan.base.data.DataBaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * @auther kagurasansan
 * @time 2019/3/31.10:13 PM
 * @des ${TODO}
 */
public class GameInfoBean extends DataBaseBean {

    /**
     * result : {"id":1161611,"Title":"疑案追声","GameType":"角色扮演","GameMake":"NEXT Studios","GameAuthor":"NEXT Studios,bilibili","ClubId":"","GameDir":"unheard","Activity":"","Position":"","EnTitle":"Unheard","Intro":"<p>　　《疑案追声》是由腾讯旗下NEXT工作室打造的推理解谜新作。本作是一款音频推理解谜游戏，主角能\u201c听到过去的声音\u201d。你要用这种能力回到案发现场，跟踪每段对话，找出幕后黑手，解开神秘悬案。<\/p>","AllTimeT":"2019/3/29 0:00:00","AllTime":"2019-03-29","SteamVideos":"[{\"SteamId\":\"942970\",\"MoviesId\":\"256737938\",\"MoviesName\":\"Unheard_CN\",\"MoviesThumbnail\":\"https://steamcdn-a.akamaihd.net/steam/apps/256737938/movie.293x165.jpg?t=1552223636\",\"MoviesWebm480\":\"http://steamcdn-a.akamaihd.net/steam/apps/256737938/movie480.webm?t=1552223636\",\"MoviesWebmMax\":\"http://steamcdn-a.akamaihd.net/steam/apps/256737938/movie_max.webm?t=1552223636\",\"MyMoviesWebm480\":\"\",\"MyMoviesWebmMax\":\"\",\"MoviesHighlight\":\"true\",\"CrawlHistoryId\":1035065,\"MyMoviesThumbnail\":\"https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130311002880.jpg\"}]","SteamImages":"https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130310541456.jpg,https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130310552273.jpg,https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130310563371.jpg,https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130310581630.jpg,https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130310593149.jpg,https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130311008027.jpg","Peizhi":"<div class=\"PZXQ\">\n<ul class=\"PZ DD\">\n  <li class=\"tit\">最低配置<\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">系统<\/div>\n  <div class=\"txt\"><span>Windows 7 / 8 / 10<\/span><\/div>\n  <\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">CPU<\/div>\n  <div class=\"txt\"><span>Intel Core i3-3220<\/span><\/div>\n  <\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">内存<\/div>\n  <div class=\"txt\"><span>4 GB<\/span><\/div>\n  <\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">显卡<\/div>\n  <div class=\"txt\"><span>NVIDIA GeForce GT 610<\/span><\/div>\n  <\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">DX<\/div>\n  <div class=\"txt\"><span>DirectX 9.0c<\/span><\/div>\n  <\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">硬盘<\/div>\n  <div class=\"txt\"><span>1 GB<\/span><\/div>\n  <\/li>\n<\/ul>\n<ul class=\"PZ TJ\">\n  <li class=\"tit\">推荐配置<\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">系统<\/div>\n  <div class=\"txt\"><span>Windows 7 / 8 / 10<\/span><\/div>\n  <\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">CPU<\/div>\n  <div class=\"txt\"><span>Intel Core i5-3470<\/span><\/div>\n  <\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">内存<\/div>\n  <div class=\"txt\"><span>8 GB<\/span><\/div>\n  <\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">显卡<\/div>\n  <div class=\"txt\"><span>NVIDIA GeForce GT 630<\/span><\/div>\n  <\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">DX<\/div>\n  <div class=\"txt\"><span>DirectX 9.0c<\/span><\/div>\n  <\/li>\n  <li class=\"txt\">\n  <div class=\"tit\">硬盘<\/div>\n  <div class=\"txt\"><span>2 GB<\/span><\/div>\n  <\/li>\n<\/ul>\n<\/div>","DeputyNodeId":"20050,20062","HandbookUrl":"","PCTime":"2019-03-29","PCTimeT":"2019/3/29 0:00:00","OfficialChinese":"1","IsFree":"False","OnLine":"4892","SteamPrice":"27","SteamInitial":"38","SteamFinal":"27","DiscountPercent":"29","DiscountText":"特价促销！4月4日 截止","PS4Time":"","PS4TimeT":"","Ps4Chinese":"","PS4HuiMian":"","XboxOneTime":"","XboxOneTimeT":"","XboxChinese":"","XboxHuiMian":"","NintendoSwitchTime":"","NintendoSwitchTimeT":"","NsChinese":"","iOSTime":"","AndroidTime":"","PS3Time":"","Xbox360Time":"","WiiUTime":"","DSTime":"","PSVitaTime":"","Ps4Prohibition":"","SteamId":"942970","Ps4Url":"","Ps4Price":"","Ps4RewardsPrice":"","Ps4RewardsDiscount":"","Ps4IsFree":"False","ThirdpartyProhibition":"False","gsScore":"7.8","wantplayCount":69,"gameTag":["角色扮演","剧情丰富","模拟","独立","解谜","悬疑","推理"],"isMarket":2,"playCount":172,"expectCount":69,"defaultPicUrl":"https://imgs.gamersky.com/ku/2019/ku_unheard.jpg"}
     */

    public ResultBean result;

    public static class ResultBean implements Serializable {
        /**
         * id : 1161611
         * Title : 疑案追声
         * GameType : 角色扮演
         * GameMake : NEXT Studios
         * GameAuthor : NEXT Studios,bilibili
         * ClubId :
         * GameDir : unheard
         * Activity :
         * Position :
         * EnTitle : Unheard
         * Intro : <p>　　《疑案追声》是由腾讯旗下NEXT工作室打造的推理解谜新作。本作是一款音频推理解谜游戏，主角能“听到过去的声音”。你要用这种能力回到案发现场，跟踪每段对话，找出幕后黑手，解开神秘悬案。</p>
         * AllTimeT : 2019/3/29 0:00:00
         * AllTime : 2019-03-29
         * SteamVideos : [{"SteamId":"942970","MoviesId":"256737938","MoviesName":"Unheard_CN","MoviesThumbnail":"https://steamcdn-a.akamaihd.net/steam/apps/256737938/movie.293x165.jpg?t=1552223636","MoviesWebm480":"http://steamcdn-a.akamaihd.net/steam/apps/256737938/movie480.webm?t=1552223636","MoviesWebmMax":"http://steamcdn-a.akamaihd.net/steam/apps/256737938/movie_max.webm?t=1552223636","MyMoviesWebm480":"","MyMoviesWebmMax":"","MoviesHighlight":"true","CrawlHistoryId":1035065,"MyMoviesThumbnail":"https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130311002880.jpg"}]
         * SteamImages : https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130310541456.jpg,https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130310552273.jpg,https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130310563371.jpg,https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130310581630.jpg,https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130310593149.jpg,https://img1.gamersky.com/thirdparty_steam/2018/12/13/201812130311008027.jpg
         * Peizhi : <div class="PZXQ">
         <ul class="PZ DD">
         <li class="tit">最低配置</li>
         <li class="txt">
         <div class="tit">系统</div>
         <div class="txt"><span>Windows 7 / 8 / 10</span></div>
         </li>
         <li class="txt">
         <div class="tit">CPU</div>
         <div class="txt"><span>Intel Core i3-3220</span></div>
         </li>
         <li class="txt">
         <div class="tit">内存</div>
         <div class="txt"><span>4 GB</span></div>
         </li>
         <li class="txt">
         <div class="tit">显卡</div>
         <div class="txt"><span>NVIDIA GeForce GT 610</span></div>
         </li>
         <li class="txt">
         <div class="tit">DX</div>
         <div class="txt"><span>DirectX 9.0c</span></div>
         </li>
         <li class="txt">
         <div class="tit">硬盘</div>
         <div class="txt"><span>1 GB</span></div>
         </li>
         </ul>
         <ul class="PZ TJ">
         <li class="tit">推荐配置</li>
         <li class="txt">
         <div class="tit">系统</div>
         <div class="txt"><span>Windows 7 / 8 / 10</span></div>
         </li>
         <li class="txt">
         <div class="tit">CPU</div>
         <div class="txt"><span>Intel Core i5-3470</span></div>
         </li>
         <li class="txt">
         <div class="tit">内存</div>
         <div class="txt"><span>8 GB</span></div>
         </li>
         <li class="txt">
         <div class="tit">显卡</div>
         <div class="txt"><span>NVIDIA GeForce GT 630</span></div>
         </li>
         <li class="txt">
         <div class="tit">DX</div>
         <div class="txt"><span>DirectX 9.0c</span></div>
         </li>
         <li class="txt">
         <div class="tit">硬盘</div>
         <div class="txt"><span>2 GB</span></div>
         </li>
         </ul>
         </div>
         * DeputyNodeId : 20050,20062
         * HandbookUrl :
         * PCTime : 2019-03-29
         * PCTimeT : 2019/3/29 0:00:00
         * OfficialChinese : 1
         * IsFree : False
         * OnLine : 4892
         * SteamPrice : 27
         * SteamInitial : 38
         * SteamFinal : 27
         * DiscountPercent : 29
         * DiscountText : 特价促销！4月4日 截止
         * PS4Time :
         * PS4TimeT :
         * Ps4Chinese :
         * PS4HuiMian :
         * XboxOneTime :
         * XboxOneTimeT :
         * XboxChinese :
         * XboxHuiMian :
         * NintendoSwitchTime :
         * NintendoSwitchTimeT :
         * NsChinese :
         * iOSTime :
         * AndroidTime :
         * PS3Time :
         * Xbox360Time :
         * WiiUTime :
         * DSTime :
         * PSVitaTime :
         * Ps4Prohibition :
         * SteamId : 942970
         * Ps4Url :
         * Ps4Price :
         * Ps4RewardsPrice :
         * Ps4RewardsDiscount :
         * Ps4IsFree : False
         * ThirdpartyProhibition : False
         * gsScore : 7.8
         * wantplayCount : 69
         * gameTag : ["角色扮演","剧情丰富","模拟","独立","解谜","悬疑","推理"]
         * isMarket : 2
         * playCount : 172
         * expectCount : 69
         * defaultPicUrl : https://imgs.gamersky.com/ku/2019/ku_unheard.jpg
         */

        public int id;
        public String Title;
        public String GameType;
        public String GameMake;
        public String GameAuthor;
        public String ClubId;
        public String GameDir;
        public String Activity;
        public String Position;
        public String EnTitle;
        public String Intro;
        public String AllTimeT;
        public String AllTime;
        public String SteamVideos;
        public String SteamImages;
        public String Peizhi;
        public String DeputyNodeId;
        public String HandbookUrl;
        public String PCTime;
        public String PCTimeT;
        public String OfficialChinese;
        public String IsFree;
        public String OnLine;
        public String SteamPrice;
        public String SteamInitial;
        public String SteamFinal;
        public String DiscountPercent;
        public String DiscountText;
        public String PS4Time;
        public String PS4TimeT;
        public String Ps4Chinese;
        public String PS4HuiMian;
        public String XboxOneTime;
        public String XboxOneTimeT;
        public String XboxChinese;
        public String XboxHuiMian;
        public String NintendoSwitchTime;
        public String NintendoSwitchTimeT;
        public String NsChinese;
        public String iOSTime;
        public String AndroidTime;
        public String PS3Time;
        public String Xbox360Time;
        public String WiiUTime;
        public String DSTime;
        public String PSVitaTime;
        public String Ps4Prohibition;
        public String SteamId;
        public String Ps4Url;
        public String Ps4Price;
        public String Ps4RewardsPrice;
        public String Ps4RewardsDiscount;
        public String Ps4IsFree;
        public String ThirdpartyProhibition;
        public String gsScore;
        public int wantplayCount;
        public int isMarket;
        public int playCount;
        public int expectCount;
        public String defaultPicUrl;
        public List<String> gameTag;
    }
}
