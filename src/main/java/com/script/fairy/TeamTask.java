package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask  extends TaskContent{
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;
    List<String> list = new ArrayList<>();

    OtherGame otherGame;
    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        mFairy1 = ypFairy;
        otherGame=new OtherGame(mFairy);
    }

    public void inOperation() throws Exception {
        result = mFairy.findPic("smOverGraph.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("In transmission.png");
        if (result.sim > 0.7f) {
            LtLog.e(mFairy.getLineInfo("传送中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("road.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("寻路中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(188, 533, 369, 592, "complete.png");
        mFairy.onTap(0.8f, result, "完成", Sleep);
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(188, 533, 369, 592, "accept.png");
        mFairy.onTap(0.8f, result, "接受", Sleep);
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
    }
    //组队任务
    public  void  aDragon(final String str,Integer x1)throws Exception{
        new TeamTask(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                int ret=gameUtil.mission(str,2);
                if (ret==1){
                    gameUtil.close(0);
                    setTaskName(2);return;
                }else {
                    setTaskEnd();return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(30,0))return;
                result = mFairy.findPic(122,106,258,187,new String[]{"duiwulan.png","duiwulan1.png"});
                mFairy.onTap(0.8f, result, "左侧队伍", Sleep);

                result = mFairy.findPic(49,10,321,107,"duiwu.png");
                if (result.sim > 0.8f ){
                    LtLog.e("队伍列表中");
                    result = mFairy.findPic(123,412,345,587,"bf.png");
                    if (result.sim > 0.8f && x1!=4) {
                        mFairy.onTap(0.8f, result, 310,440,318,450,"左侧队伍", Sleep);
                    }

                    result = mFairy.findPic(120,97,343,613,"zd"+x1+".png");
                    if (result.sim > 0.8f ) {
                        mFairy.onTap(0.8f, result, "队伍类型点击", Sleep);
                        setTaskName(3);return;
                    }
                }

            }
            int y=0;
            public void content_3() throws Exception {

                if (overtime(30,0))return;
                result = mFairy.findPic(869,547,1199,668,"qhmb.png");
                if (result.sim > 0.8f ) {
                    mFairy.onTap(0.8f, result, 175,186,286,208,"已入队，打开我的队伍", Sleep);
                }else{
                    result = mFairy.findPic(985,560,1194,657,"cjdw.png");
                    mFairy.onTap(0.8f, result, "创建队伍", Sleep);
                }

                result = mFairy.findPic(323,160,951,560,"qdcj.png");
                mFairy.onTap(0.8f, result, 762,503,809,513,"确定创建队伍", Sleep);

                result = mFairy.findPic(334,87,820,170,"mb"+x1+".png");
                if (result.sim > 0.8f ) {
                    setTaskName(4);return;
                }else{
                    y++;
                }
                if (y>=5){
                    y=0;
                    setTaskName(0);return;
                }
            }
            int mannum=0;
            public void content_4() throws Exception {
                if (overtime(30, 0)) return;
                result = mFairy.findPic(334, 87, 820, 170, "mb" + x1 + ".png");
                if (result.sim > 0.8f) {
                    err=0;
                    LtLog.e("目标队伍中！");
                    mFairy.sleep(2000);


                    result = mFairy.findPic(776, 592, 905, 637, "wgx.png");
                    mFairy.onTap(0.8f, result, "勾选自动入队", Sleep);

                    result = mFairy.findPic(554, 165, 756, 549, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum = 2;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }

                    result = mFairy.findPic(757, 166, 960, 546, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum = 3;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }

                    result = mFairy.findPic(961, 168, 1162, 544, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum = 4;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }
                    if (mannum >= 3) {
                        LtLog.e(mFairy.getLineInfo("人满了出发"));
                        setTaskName(5);
                        return;
                    }
                    if (timekeep(1, 120000, "2分钟招募一下")) {
                        LtLog.e(mFairy.getLineInfo("--------2分钟招募一下"));
                        gameUtil.yjhh();
                    }
                    if (timekeep(0, 600000, "超过10分钟没组到人")) {
                        LtLog.e(mFairy.getLineInfo("--------超过10分钟没组到人"));
                        setTaskName(0);
                        return;
                    }
                }

            }
            public void content_5() throws Exception {
                if (overtime(60,2))return;
                if(x1==5){
                    result = mFairy.findPic(334,87,820,170,"mb5.png");
                    if (result.sim>0.8f){
                        result = mFairy.findPic(933,559,1206,663,"jrhd.png");
                        if (result.sim>0.8f) {
                            mFairy.onTap(0.9f, result, "进入活动", Sleep);
                            for (int i = 0; i < 20; i++) {
                                result = mFairy.findPic(675,459,906,556,"qw1.png");
                                mFairy.onTap(0.8f, result, "前往", Sleep);

                                result1 = mFairy.findPic(481,118,824,273,new String[]{"rsbz.png"});
                                if(result1.sim>0.75f){
                                    LtLog.i(mFairy.getLineInfo("人数不足"));
                                    setTaskName(4);
                                    return;
                                }
                                LtLog.e("循环");
                            }
                        }
                    }

                    result = mFairy.findPic(675,459,906,556,"qw1.png");
                    mFairy.onTap(0.8f, result, "前往", Sleep);

                    result = mFairy.findPic(498,265,796,357,"dd.png");
                    mFairy.onTap(0.8f, result, 617,502,665,521,"等待前往", 3000);

                    result = mFairy.findPic(942,475,1245,713,"wmch.png");
                    mFairy.onTap(0.8f, result, "为民除害", Sleep);

                    result = mFairy.findPic(942,475,1245,713,"js.png");
                    mFairy.onTap(0.8f, result, "结束对话", Sleep);

                    result = mFairy.findPic(942,475,1245,713,"et.png");
                    mFairy.onTap(0.8f, result, "恶徒", 10000);

                    result = mFairy.findPic(432,81,814,275,"sstjjs.png");
                    if (result.sim>0.8f){
                        LtLog.e("杀手结束一次");
                        setTaskName(0);
                        return;
                    }

                    result = mFairy.findPic(779,615,839,714,"ltzk.png");
                    mFairy.onTap(0.8f, result, "展开聊天", 500);

                    result = mFairy.findPic(425,513,831,720,"sstjjs1.png");
                    if (result.sim>0.8f){
                        LtLog.e("杀手结束一次");
                        setTaskName(0);
                        return;
                    }




                }

            }
        }.taskContent(mFairy,"组队任务任务中");
    }

    //一条龙扫荡
    public  void  aDragon1(final String str)throws Exception{
        new TeamTask(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                int ret=gameUtil.mission(str,1);
                if (ret==1){
                    setTaskName(2);return;
                }else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(49, 376, 495, 586, new  String[]{"LeftCopy.png","LeftCopy1.png","LeftPoyougu.png","LeftZhuRong.png"});
                mFairy.onTap(0.8f, result, "左侧副本", Sleep);

                result =mFairy.findPic(365, 521, 1117, 604,"sdldengji.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("使用等级不足"));
                    setTaskEnd();return;
                }
                result =mFairy.findPic("sdlinsufficient.png");
                mFairy.onTap(0.8f, result,  514, 443, 515, 444,"扫荡令不足", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("扫荡令不足"));
                    setTaskEnd();return;
                }
                result =mFairy.findPic("ytlEnterCopy1.png");
                mFairy.onTap(0.8f, result,   630, 614, 631, 615,"进入副本1", Sleep);

                result =mFairy.findPic(583,575,910,655,"brcsyyw.png");
                if (result.sim > 0.8f){
                    LtLog.e("没有次数");
                    setTaskEnd();return;
                }

                result1 =mFairy.findPic(417,563,1088,649,"sdlInterface.png");
                result =mFairy.findPic(578,563,951,657,"ytlEnterCopy.png");
                /*mFairy.onTap(0.8f, result,    588,604,616,621,"进入副本", Sleep);*/
                if (result.sim > 0.8f && result1.sim <0.8f){
                    LtLog.e("没有扫荡");
                    setTaskEnd();return;
                }

                result =mFairy.findPic(453,557,1034,667,"sdlInterface.png");
                mFairy.onTap(0.8f, result,    583,608,590,611,"扫荡副本", Sleep);
                result =mFairy.findPic(302,179,961,255,"sdlInterface1.png");
                mFairy.onTap(0.8f, result,    371, 373,372, 374,"扫荡令界面", Sleep);
                mFairy.onTap(0.8f, result,    772, 467,773, 468,"扫荡令界面", 2000);
                if (result.sim > 0.8f) {
                    result =mFairy.findPic("sdlinsufficient.png");
                    mFairy.onTap(0.8f, result,  514, 443, 515, 444,"扫荡令不足", Sleep);
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("扫荡令不足"));
                        setTaskEnd();return;
                    }
                }
            }
        }.taskContent(mFairy,"一条龙扫荡中");
    }

    //组人
    public  void  organizeTeam()throws Exception{
        new TeamTask(mFairy){
            @Override
            public void content_0() throws Exception {
                 gameUtil.close(1);
                 setTaskName(1);return;
            }
            int rsnum=0;
            public void content_1() throws Exception {
                result = mFairy.findPic("LeftCaptain.png");
                mFairy.onTap( 0.9f, result, "左侧队伍", Sleep);

                result = mFairy.findPic("qwzd.png");
                mFairy.onTap( 0.8f, result, "前往组队", Sleep);

                result = mFairy.findPic("CreateTeam.png");
                mFairy.onTap( 0.8f, result, "创建队伍", Sleep);

                result = mFairy.findPic("CreateTeam1.png");
                mFairy.onTap( 0.8f, result, 606,236,607,237,"目标", Sleep);
                mFairy.onTap( 0.8f, result, 531,300,547,307,"一条龙", Sleep);
                mFairy.onTap( 0.8f, result, "创建队伍", Sleep);

                result = mFairy.findPic("RecruitM.png");
                if (result.sim > 0.8f) {
                    if (timekeep(1,120000,"2分钟招募一下")){
                        LtLog.e(mFairy.getLineInfo("--------2分钟招募一下"));
                        mFairy.onTap( 0.8f, result, "招募成员", Sleep);
                        mFairy.onTap( 0.8f, result, 653, 120,654, 121,"招募频道", Sleep);
                        mFairy.onTap( 0.8f, result, "招募成员", Sleep);
                        mFairy.onTap( 0.8f, result, 657, 165,658, 166,"血盟频道", Sleep);
                        mFairy.onTap( 0.8f, result, "招募成员", Sleep);
                        mFairy.onTap( 0.8f, result, 650, 213,651, 214,"附近频道", Sleep);
                    }
                }
                result = mFairy.findPic("jindui.png");
                mFairy.onTap( 0.8f, result, "有人进队", Sleep);

                result = mFairy.findPic(891, 205, 1015, 564,"agree.png");
                mFairy.onTap( 0.8f, result, "同意别人进队", Sleep);
                rsnum=0;
                result = mFairy.findPic(341, 257, 602, 336,"ytlPeople.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进来个人"));
                    rsnum++;
                }

                result = mFairy.findPic(339, 350, 602, 432, "ytlPeople.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进来个人"));
                    rsnum++;
                }
                result = mFairy.findPic(336, 447, 602, 527, "ytlPeople.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进来个人"));
                    rsnum++;
                }
                result = mFairy.findPic(333, 541, 603, 625, "ytlPeople.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进来个人"));
                    rsnum++;
                }

                if (rsnum > 1) {
                    Thread.sleep(2000);
                    result = mFairy.findPic("HeelStation.png");
                    mFairy.onTap( 0.8f, result, "发起跟站", Sleep);
                    Thread.sleep(2000);

                    result = mFairy.findPic("gzSure.png");
                    mFairy.onTap( 0.8f, result, "跟站确定", Sleep);

                    mFairy.onTap( 707, 313,708, 314,"收起组队框", Sleep);
                    gameUtil.close(1);
                    setTaskEnd();return;
                }
                if (timekeep(0,600000,"超过10分钟没组到人")){
                    LtLog.e(mFairy.getLineInfo("--------超过10分钟没组到人"));
                    setTaskName(0);
                    return;
                }
                Thread.sleep(2000);
            }
        }.taskContent(mFairy,"组人任务中");
    }

    //杀手通缉
    public void sstj()throws Exception{
        new TeamTask(mFairy){
            @Override
            public void content_0() throws Exception {
                result = mFairy.findPic(942,475,1245,713,"wmch.png");
                mFairy.onTap(0.8f, result, "为民除害", Sleep);

                result = mFairy.findPic(942,475,1245,713,"js.png");
                mFairy.onTap(0.8f, result, "结束对话", Sleep);

                result = mFairy.findPic(942,475,1245,713,"et.png");
                mFairy.onTap(0.8f, result, "恶徒", 10000);

                result = mFairy.findPic(942,475,1245,713,"et.png");
                if (result.sim>0.8f){
                    LtLog.e("杀手中");
                    mFairy.onTap(0.8f, result, result.x+8,result.y+78,result.x+17,result.y+91,"恶徒", 1000);
                }

                result = mFairy.findPic(432,81,814,275,"sstjjs.png");
                if (result.sim>0.8f){
                    LtLog.e("杀手结束一次");
                    return;
                }


            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("sstj.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                result = mFairy.findPic("LeftCaptain.png");
                mFairy.onTap( 0.9f, result, "左侧队伍", Sleep);

                result = mFairy.findPic("qwzd.png");
                mFairy.onTap( 0.8f, result, "前往组队", Sleep);

                result = mFairy.findPic("CreateTeam.png");
                mFairy.onTap( 0.8f, result, "创建队伍", Sleep);

                result = mFairy.findPic("CreateTeam1.png");
                mFairy.onTap( 0.8f, result, 606,236,607,237,"目标", Sleep);
                mFairy.onTap( 0.8f, result, 531,300,547,307,"一条龙", Sleep);
                mFairy.onTap( 0.8f, result, "创建队伍", Sleep);

                result = mFairy.findPic("RecruitM.png");
                if (result.sim > 0.8f) {
                    if (timekeep(1,120000,"2分钟招募一下")){
                        LtLog.e(mFairy.getLineInfo("--------2分钟招募一下"));
                        mFairy.onTap( 0.8f, result, "招募成员", Sleep);
                        mFairy.onTap( 0.8f, result, 653, 120,654, 121,"招募频道", Sleep);
                        mFairy.onTap( 0.8f, result, "招募成员", Sleep);
                        mFairy.onTap( 0.8f, result, 657, 165,658, 166,"血盟频道", Sleep);
                        mFairy.onTap( 0.8f, result, "招募成员", Sleep);
                        mFairy.onTap( 0.8f, result, 650, 213,651, 214,"附近频道", Sleep);
                    }
                }
                result = mFairy.findPic("jindui.png");
                mFairy.onTap( 0.8f, result, "有人进队", Sleep);

                Thread.sleep(2000);
            }
        }.taskContent(mFairy,"杀手通缉任务中");
    }

}
