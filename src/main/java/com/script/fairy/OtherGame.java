package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import java.util.Random;

/**
 * Created by Administrator on 2019/11/5 0005.
 */

public class OtherGame  extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;
    public OtherGame(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
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

    public  void  nongchang()throws Exception{
        new OtherGame(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                int ret=gameUtil.mission("Farm.png",1);
                if (ret==1){
                    setTaskName(2);return;
                }else {
                    setTaskEnd();return;
                }
            }
            int food=Integer.parseInt(AtFairyConfig.getOption("food"));
            public void content_2() throws Exception {
                if (overtime(30,99))return;
                Thread.sleep(1000);
                result =mFairy.findPic(265,249,1002,526,"VacantLand.png");
                mFairy.onTap(0.8f,result,"种菜",Sleep);

                result =mFairy.findPic(686,405,868,478,"scSure.png");
                mFairy.onTap(0.8f,result,"去地块确定",Sleep);
                if (result.sim>0.8f){
                    setTaskName(3);return;
                }
            }
            public void content_3() throws Exception {
                if (overtime(60,0)){
                    mFairy.ranSwipe(172,570,273,571,1500, (long) 1500,2);
                    return;
                }
                result =mFairy.findPic("zcFood.png");
                mFairy.onTap(0.8f,result,"种菜选菜",Sleep);
                mFairy.onTap(0.8f,result,139,114,171,129,"选个菜",Sleep);

                result =mFairy.findPic(new String[]{"zhongzhi.png","Sow.png"});
                mFairy.onTap(0.8f,result,"播种",Sleep);
                if (result.sim>0.8f){
                    result =mFairy.findPic(420,102,886,208,"zdsx.png");
                    if (result.sim>0.7f) {
                        LtLog.e(mFairy.getLineInfo("种菜达到上限"));
                        setTaskEnd();return;
                    }
                }

                result =mFairy.findPic("Harvest.png");
                mFairy.onTap(0.8f,result,"收获",Sleep);

                result =mFairy.findPic("SowSure1.png");
                mFairy.onTap(0.8f,result,"播种确定",6000);

                result =mFairy.findPic("zcShop.png");
                if (result.sim>0.8f) {
                    LtLog.e(mFairy.getLineInfo("商店没菜了要买菜"));
                    if (food == 1) {
                        mFairy.tap(358, 186);
                    }
                    if (food == 2) {
                        mFairy.tap(693, 186);
                    }
                    if (food == 3) {
                        mFairy.tap(358, 296);
                    }
                    if (food == 4) {
                        mFairy.tap(325, 100);
                        Thread.sleep(2000);
                        mFairy.tap(358, 186);
                    }
                    if (food == 5) {
                        mFairy.tap(325, 100);
                        Thread.sleep(2000);
                        mFairy.tap(693, 186);
                    }
                    if (food == 6) {
                        mFairy.tap(325, 100);
                        Thread.sleep(2000);
                        mFairy.tap(358, 296);
                    }
                    if (food == 7) {
                        mFairy.tap(325, 100);
                        Thread.sleep(2000);
                        mFairy.tap(693, 298);
                    }
                    if (food == 8) {
                        mFairy.tap(325, 100);
                        Thread.sleep(2000);
                        mFairy.tap(358, 404);
                    }
                    if (food == 9) {
                        mFairy.tap(325, 100);
                        Thread.sleep(2000);
                        mFairy.tap(693, 404);
                    }
                    if (food == 10) {
                        mFairy.tap(465, 98);
                        Thread.sleep(2000);
                        mFairy.tap(358, 186);
                    }
                    if (food == 11) {
                        mFairy.tap(465, 98);
                        Thread.sleep(2000);
                        mFairy.tap(693, 186);
                    }
                    if (food == 12) {
                        mFairy.tap(465, 98);
                        Thread.sleep(2000);
                        mFairy.tap(358, 296);
                    }
                    if (food == 13) {
                        mFairy.tap(465, 98);
                        Thread.sleep(2000);
                        mFairy.tap(693, 298);
                    }
                    if (food == 14) {
                        mFairy.tap(465, 98);
                        Thread.sleep(2000);
                        mFairy.tap(358, 404);
                    }
                    if (food == 15) {
                        mFairy.tap(465, 98);
                        Thread.sleep(2000);
                        mFairy.tap(693, 404);
                    }
                    Thread.sleep(2000);
                    mFairy.onTap(1043,489,1053,503,"买三个",Sleep);
                    mFairy.onTap(1043,489,1053,503,"买三个",Sleep);
                    mFairy.onTap(1043,489,1053,503,"买三个",Sleep);
                    mFairy.onTap(974,623,1001,641,"立即购买",Sleep);
                    mFairy.onTap(757,430,788,451,"立即购买",Sleep);
                    mFairy.onTap(1147,52,1165,64,"立即购买",Sleep);
                }
                result =mFairy.findPic("eradicate.png");
                if (result.sim>0.8f) {
                    LtLog.e(mFairy.getLineInfo("已经种了菜了"));
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy,"血盟农场任务中");
    }//血盟农场

    public void dxz() throws Exception {
        new OtherGame(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                if (mFairy.dateHour()<10){
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }
            int rsnum=0;
            public void content_1() throws Exception {
                result = mFairy.findPic("liaotiankuang.png");
                mFairy.onTap( 0.8f, result, "收起聊天框" , Sleep);

                result = mFairy.findPic("LeftCaptain.png");
                mFairy.onTap( 0.9f, result, "左侧队伍", Sleep);

                result = mFairy.findPic("CreateTeam.png");
                mFairy.onTap( 0.8f, result, "创建队伍", Sleep);

                result = mFairy.findPic("CreateTeam1.png");
                mFairy.onTap( 0.8f, result, 606,236,607,237,"目标", Sleep);
                mFairy.onTap( 0.8f, result, 517,671,547,676,"无目标", Sleep);
                mFairy.onTap( 0.8f, result, "创建队伍", Sleep);


                result = mFairy.findPic("jindui.png");
                mFairy.onTap( 0.8f, result, "有人进队", Sleep);

                result = mFairy.findPic(891, 205, 1015, 564,"agree.png");
                mFairy.onTap( 0.8f, result, "同意别人进队", Sleep);
                rsnum=0;
                result = mFairy.findPic(341, 257, 602, 336,"ytlPeople.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进来1个人"));
                    rsnum++;
                }

                result = mFairy.findPic(339, 350, 602, 432, "ytlPeople.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进来2个人"));
                    rsnum++;
                }
                result = mFairy.findPic(336, 447, 602, 527, "ytlPeople.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进来3个人"));
                    rsnum++;
                }
                result = mFairy.findPic(333, 541, 603, 625, "ytlPeople.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进来4个人"));
                    rsnum++;
                }

                if (rsnum > 1) {
                    mFairy.onTap( 707, 313,708, 314,"收起组队框", Sleep);
                    gameUtil.close(1);
                    setTaskName(3);return;
                }else {
                    if (timekeep(0,120000,"2分钟喊下话")){
                             setTaskName(2);return;
                    }
                }
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
                if (timekeep(0,600000,"超过10分钟没组到人")){
                    LtLog.e(mFairy.getLineInfo("--------超过10分钟没组到人"));
                    setTaskName(0);
                    return;
                }
                Thread.sleep(2000);
            }
            public void content_2() throws Exception {
                if (overtime(20, 0)) return;
                result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                mFairy.onTap(0.8f, result, 813,606,814,607, "日常", Sleep);

                result = mFairy.findPic(5,9,103,621, "hhshijie.png");
                mFairy.onTap(0.8f, result, "世界", Sleep);

                result = mFairy.findPic(5,9,103,621, "hhshijie1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 189,660,209,670,"打开输入框", 3000);
                    mFairy.inputText("打雪仗来人+++++");
                    mFairy.condit();
                    result = mFairy.findPic(1191,140,1262,203,new String[]{"new_textsure.png","new_textsure1.png","new_textsure2.png"});
                    mFairy.onTap(0.7f, result,   "确定文本", 2000);
                    mFairy.onTap(0.7f, result,   544,657,583,671,"发送", 2000);
                    mFairy.onTap(0.7f, result,   622,311,632,329,"收起聊天框", 2000);
                    setTaskName(0);return;
                }
            }
            public void content_3() throws Exception {
                if (overtime(20, 0)) return;
                result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                mFairy.onTap(0.8f, result, 1074,34,1085,49, "日常", Sleep);

                result = mFairy.findPic("dxztcfb.png");
                mFairy.onTap(0.8f, result, 507,430,542,444, "取消退出副本", Sleep);

                result = mFairy.findPic("fenjie.png");
                if (result.sim>0.8f){
                    result = mFairy.findPic(442, 1, 1277, 513, new String[]{"fork.png","fork1.png"});
                    mFairy.onTap(0.8f, result, "关叉", 2000);
                }

                result = mFairy.findPic(605,19,1115,278, "daxuezhang.png");
                mFairy.onTap(0.8f, result, "打雪仗", Sleep);

                result = mFairy.findPic( "xzqd.png");
                mFairy.onTap(0.8f, result, "取消战袍", Sleep);

                result = mFairy.findPic( "xueren.png");
                mFairy.onTap(0.8f, result, "打雪 人", Sleep);

                result = mFairy.findPic("dxzpp.png");
                mFairy.onTap(0.8f, result, "组队匹配", Sleep);
                if (result.sim > 0.8f) {
                    err=0;
                }

                result = mFairy.findPic("dxzrbgou.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("人不够"));
                    setTaskName(0);return;
                }

                result = mFairy.findPic("ppz.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                    err=0;
                }

                result =mFairy.findPic("jybattle.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);


                result =mFairy.findPic("xqdzz.png");
                if (result.sim > 0.8f) {
                    err=0;
                    LtLog.e(mFairy.getLineInfo("冰雪大作战内"));
                    int x = new Random().nextInt(170) + 87;
                    int y = new Random().nextInt(164) + 493;
                    mFairy.ranSwipe(172,570, x, y, 2000, (long) 1000, 2);

                    mFairy.onTap(0.8f,result,1177,608,1197,624,"普工一下",100);
                    mFairy.onTap(0.8f,result,1177,608,1197,624,"普工一下",100);
                    mFairy.onTap(0.8f,result,1177,608,1197,624,"普工一下",100);

                    result =mFairy.findPic("Openbox.png");
                    mFairy.onTap(0.8f,result,"开箱",5000);

                }
                result =mFairy.findPic("xqlikai.png");
                mFairy.onTap(0.8f,result,"离开",Sleep);
            }

        }.taskContent(mFairy, "打雪仗中");
    }//打雪仗

    public void dxz1() throws Exception {
        new OtherGame(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                if (mFairy.dateHour()<10){
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }
            int rsnum=0;
            public void content_1() throws Exception {
                Thread.sleep(1000);
                result = mFairy.findPic("dxzzhidaole.png");
                mFairy.onTap( 0.8f, result, "知道了" , Sleep);

                result =mFairy.findPic("jybattle.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);

                result =mFairy.findPic("xqdzz.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("冰雪大作战内"));
                    int x = new Random().nextInt(170) + 87;
                    int y = new Random().nextInt(164) + 493;
                    mFairy.ranSwipe(172,570, x, y, 2000, (long) 1000, 2);

                    mFairy.onTap(0.8f,result,1177,608,1197,624,"普工一下",100);
                    mFairy.onTap(0.8f,result,1177,608,1197,624,"普工一下",100);
                    mFairy.onTap(0.8f,result,1177,608,1197,624,"普工一下",100);

                    result =mFairy.findPic("Openbox.png");
                    mFairy.onTap(0.8f,result,"开箱",5000);

                }
                result =mFairy.findPic("xqlikai.png");
                mFairy.onTap(0.8f,result,"离开",Sleep);

                result = mFairy.findPic("dxztcfb.png");
                mFairy.onTap(0.8f, result, 507,430,542,444, "取消退出副本", Sleep);
            }
        }.taskContent(mFairy, "跟队打雪仗中");
    }//跟队打雪仗


}
