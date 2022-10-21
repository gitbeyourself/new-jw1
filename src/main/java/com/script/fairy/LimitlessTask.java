package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import java.util.List;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class  LimitlessTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    TimingActivity timingActivity;
    GameUtil gameUtil;
    OtherGame otherGame;
    SingleTask singleTask;
    TeamTask teamTask;

    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        timingActivity = new TimingActivity(mFairy);
        otherGame = new OtherGame(mFairy);
        singleTask = new SingleTask(mFairy);
        teamTask = new TeamTask(mFairy);
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
        result = mFairy.findPic(447,493,855,566,new String[]{"In transmission.png","In transmission1.png"});
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

    static int szmap = 0;

    public void fieldHangMachine() throws Exception {
        new LimitlessTask(mFairy) {

            int gmx = 0, gmy = 0, yhsr = 0;//地图
            ControlSplit back =null, sywp = null;
            //xzdt 选择地图 totem图腾 zb坐标 ditunum地图NO
            @Override
            public void create() throws Exception {
                timingActivity.timingActivity();
                //定位坐标
                if (!AtFairyConfig.getOption("back").equals("")) {
                    back = strSplit(AtFairyConfig.getOption("back"));
                }


            }

            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic(91,234,1038,551,new String[]{"death.png","death2.png"});
                result1 = mFairy.findPic(415,333,577,419,"ky.png");
                if(result.sim > 0.8f && result1.sim < 0.8f){
                    mFairy.onTap(0.8f, result, "复活", Sleep);
                    setTaskName(0);
                    return;
                }

                result1 = mFairy.findPic(40,457,395,697,"tcsdms.png");
                mFairy.onTap(0.8f, result1, "退出省电模式", Sleep);

            }

            public void content_0() throws Exception {

                while (mFairy.condit()){
                    if (!(AtFairyConfig.getOption("xzdt").equals("") || AtFairyConfig.getOption("zb1").equals("") || AtFairyConfig.getOption("xzdt").equals("0"))){
                        yhsr = Integer.parseInt(AtFairyConfig.getOption("xzdt"));
                        String[] arr = AtFairyConfig.getOption("zb1").split(",");
                        gmx = Integer.parseInt(arr[0]);
                        gmy = Integer.parseInt(arr[1]);
                        LtLog.e(mFairy.getLineInfo("哪个地图=" + yhsr + ",坐标=" + gmx + "," + gmy));
                        break;
                    }else{

                    }
                }
                gameUtil.close(1);
                setTaskName(1);
                return;
            }

            int tu1 = 0, ceng1 = 0;
            String tu="";
            public void content_1() throws Exception {
                if (overtime(10, 0)) return;
                mFairy.sleep(1000);
                tu1 = 0;
                ceng1 = 0;

                result = mFairy.findPic(1053,1,1101,88,new String[]{"hdkzl.png","hdkzl2.png"});
                mFairy.onTap(0.8f, result, "活动展开", Sleep);

                result1 = mFairy.findPic(1093,234,1270,602,"sz.png");
                result = mFairy.findPic(612,4,1103,176,"activity.png");
                if (result.sim > 0.8f  || result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1188, 83, 1193, 93, "打开地图", 3000);
                }
                //查看当前的位置
                result = mFairy.findPic(856,579,1121,670,"hcWorld.png");
                if (result.sim > 0.8f) {
                    LtLog.e("地图内");
                    Thread.sleep(2000);
                    mFairy.condit();
                    for (int i = 0; i < 32; i++) {
                        result1 = mFairy.findPic(139,18,403,117,"gjdigong" + i + ".png");
                        if (result1.sim > 0.9f) {
                            switch (i) {
                                case 1:
                                    LtLog.e(mFairy.getLineInfo("少林"));
                                    tu1 = 1;
                                    break;
                                case 2:
                                    LtLog.e(mFairy.getLineInfo("天王帮"));
                                    tu1 = 2;
                                    break;
                                case 3:
                                    LtLog.e(mFairy.getLineInfo("唐门"));
                                    tu1 = 3;
                                    break;
                                case 4:
                                    LtLog.e(mFairy.getLineInfo("五毒"));
                                    tu1 = 4;
                                    break;
                                case 5:
                                    LtLog.e(mFairy.getLineInfo("峨眉"));
                                    tu1 = 5;
                                    break;
                                case 6:
                                    LtLog.e(mFairy.getLineInfo("翠烟"));
                                    tu1 = 6;
                                    break;
                                case 7:
                                    LtLog.e(mFairy.getLineInfo("丐帮"));
                                    tu1 = 7;
                                    break;
                                case 8:
                                    LtLog.e(mFairy.getLineInfo("天忍教"));
                                    tu1 = 8;
                                    break;
                                case 9:
                                    LtLog.e(mFairy.getLineInfo("武当"));
                                    tu1 = 9;
                                    break;
                                case 10:
                                    LtLog.e(mFairy.getLineInfo("昆仑"));
                                    tu1 = 10;
                                    break;
                                case 11:
                                    LtLog.e(mFairy.getLineInfo("风陵渡渡口"));
                                    tu1 = 11;
                                    break;
                                case 12:
                                    LtLog.e(mFairy.getLineInfo("漠北草原180"));
                                    tu1 = 12;
                                    break;
                                case 13:
                                    LtLog.e(mFairy.getLineInfo("剑门关160"));
                                    tu1 = 13;
                                    break;
                                case 14:
                                    LtLog.e(mFairy.getLineInfo("千寻塔140"));
                                    tu1 = 14;
                                    break;
                                case 15:
                                    LtLog.e(mFairy.getLineInfo("长白山120"));
                                    tu1 = 15;
                                    break;
                                case 16:
                                    LtLog.e(mFairy.getLineInfo("沙漠山洞100"));
                                    tu1 = 16;
                                    break;
                                case 17:
                                    LtLog.e(mFairy.getLineInfo("青螺岛100"));
                                    tu1 = 17;
                                    break;
                                case 18:
                                    LtLog.e(mFairy.getLineInfo("老虎洞80"));
                                    tu1 = 18;
                                    break;
                                case 19:
                                    LtLog.e(mFairy.getLineInfo("桃花源80"));
                                    tu1 = 19;
                                    break;
                                case 20:
                                    LtLog.e(mFairy.getLineInfo("药王谷60"));
                                    tu1 = 20;
                                    break;
                                case 21:
                                    LtLog.e(mFairy.getLineInfo("莫高窟60"));
                                    tu1 = 21;
                                    break;
                                case 22:
                                    LtLog.e(mFairy.getLineInfo("秦始皇陵60"));
                                    tu1 = 22;
                                    break;
                                case 23:
                                    LtLog.e(mFairy.getLineInfo("古战场80"));
                                    tu1 = 23;
                                    break;
                                case 24:
                                    LtLog.e(mFairy.getLineInfo("临渝关40"));
                                    tu1 = 24;
                                    break;
                                case 25:
                                    LtLog.e(mFairy.getLineInfo("华山40"));
                                    tu1 = 25;
                                    break;
                                case 26:
                                    LtLog.e(mFairy.getLineInfo("火狼词40"));
                                    tu1 = 26;
                                    break;
                                case 27:
                                    LtLog.e(mFairy.getLineInfo("武夷山40"));
                                    tu1 = 27;
                                    break;
                                case 28:
                                    LtLog.e(mFairy.getLineInfo("响水洞20"));
                                    tu1 = 28;
                                    break;
                                case 29:
                                    LtLog.e(mFairy.getLineInfo("青城山20"));
                                    tu1 = 29;
                                    break;
                                case 30:
                                    LtLog.e(mFairy.getLineInfo("伏牛山20"));
                                    tu1 = 30;
                                    break;
                                case 31:
                                    LtLog.e(mFairy.getLineInfo("荐菊洞20"));
                                    tu1 = 31;
                                    break;
                                case 32:
                                    LtLog.e(mFairy.getLineInfo("点苍山20"));
                                    tu1 = 32;
                                    break;
                            }
                            break;
                        }
                    }

                    result1 = mFairy.findPic(139,18,403,117,"gjdigong50.png");
                    if (result1.sim > 0.9f) {
                        LtLog.e(mFairy.getLineInfo("少林"));
                        tu1 = 50;
                    }

                    result1 = mFairy.findPic(459,244,809,469,new String[]{"tn.png","dcs.png"});
                    if (tu1==14 && result1.sim > 0.9f) {
                        LtLog.e(mFairy.getLineInfo("千寻塔外"));
                        tu1 = 0;
                    }

                    LtLog.e("查看地图位于："+tu1);
                    if (tu1==0 || yhsr != tu1) {

                        LtLog.e(mFairy.getLineInfo("不在一个地图"));
                        gameUtil.goCity(yhsr);

                        result = mFairy.findPic(856,579,1121,670,"hcWorld.png");;
                        mFairy.onTap(0.8f, result, 1096,54,1113,69,"关闭地图", Sleep);

                        setTaskName(7);
                        return;
                    }else{
                        setTaskName(7);
                        return;
                    }
                }
            }

            public void content_7() throws Exception {
                if (overtime(30, 0)) return;
                gameUtil.moshi();

                result = mFairy.findPic(612,4,1103,176,"activity.png");
                mFairy.onTap(0.8f, result, 1188,83,1193,93, "打开地图", 3000);

                result = mFairy.findPic(856,579,1121,670,"hcWorld.png");
                if (result.sim > 0.8f) {
                    gameUtil.coordinate(yhsr, gmx, gmy);
                    timekeepInit("定位坐标");
                    mFairy.initMatTime();

                    if (!AtFairyConfig.getOption("fjrd").equals("") || AtFairyConfig.getOption("fjrd") != null) {

                            result = mFairy.findPic(3,113,263,186,"duiwulan.png");
                            mFairy.onTap(0.8f, result, "切换到队伍栏", Sleep);

                            result = mFairy.findPic(3,186,263,347,"around.png");
                            mFairy.onTap(0.8f, result, "周围队伍", Sleep);

                            result = mFairy.findPic(254,67,1073,275,"around1.png");
                            if (result.sim > 0.8f) {
                                result = mFairy.findPic(843,47,1065,280,"apply.png");
                                if (result.sim > 0.8f) {
                                    mFairy.onTap(0.8f, result, "申请入队", 2000);
                                }else{
                                    mFairy.onTap(998,104,1004,113,"关闭", Sleep);
                                }
                             }

                            result = mFairy.findPic(362,217,935,388,"success.png");
                            mFairy.onTap(0.8f, result, 477,506,494,515,"取消", Sleep);
                            result = mFairy.findPic(362,217,935,388,"success.png");
                            mFairy.onTap(0.8f, result, 477,506,494,515,"取消", Sleep);

                    }
                    setTaskName(8);
                    return;
                }

            }//定位到坐标 到8开始挂机

            public void content_8() throws Exception {
                int h = mFairy.dateHour();
                int m = mFairy.dateMinute();
                result = mFairy.findPic(1091,636,1184,718, new String[]{"sdzd.png", "sdzd1.png"});
                mFairy.onTap(0.8f,result, "开启自动战斗", Sleep);
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 40) {
                    mFairy.initMatTime();
                    setTaskName(7);
                    return;
                }
                if (AtFairyConfig.getOption("gxrc").equals("1")  && h==5  && m==1){
                    timingActivity.hjsl=true;timingActivity.ywsl=true;timingActivity.fldc=true;timingActivity.bhkh=true;timingActivity.sjsl=true;
                    timingActivity.sjzc=true;timingActivity.mpjj=true;timingActivity.wlls=true;timingActivity.zjjy=true;timingActivity.gcz=true;
                    timingActivity.xflj=true;timingActivity.elrq=true;timingActivity.ydbz=true;timingActivity.hjsl1=true;
                    LtLog.e("5点重置任务" );
                    create();
                    setTaskName(0);
                    return;
                }
                //限时任务
                if (timingActivity.timingActivity() == 1) {
                    setTaskName(0);
                    return;
                }
                if (mFairy.dateHour()==0 && mFairy.dateMinute()==1){
                    timingActivity = new TimingActivity(mFairy);
                    Thread.sleep(60000);
                }
                if (back != null && back.choice == 1 && timekeep(0, back.timeMillis, "定位坐标")) {
                    LtLog.e(mFairy.getLineInfo("定位坐标一次"));
                    setTaskName(7);//每隔多少分定位坐标一次
                    return;
                }
                LtLog.e("使用物品"+(sywp != null  && timekeep(0, sywp.timeMillis, "野外挂机使用物品")));

            }

            public void content_9() throws Exception {
                gameUtil.moshi();
                if (timingActivity.timingActivity() == 1) {
                    setTaskName(0);
                    return;
                }
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 40) {
                    mFairy.initMatTime();
                    for (int i = 0; i < 20; i++) {
                        mFairy.condit();

                        if (i == 19) {
                            LtLog.e(mFairy.getLineInfo("发呆40秒了重置"));
                            setTaskName(0);
                            return;
                        }
                        Thread.sleep(1000);
                    }
                }
                if (mFairy.dateHour()==0 && mFairy.dateMinute()==1){
                    timingActivity = new TimingActivity(mFairy);
                    Thread.sleep(60000);
                }

                result1 = mFairy.findPic("bagM1.png");
                result = mFairy.findPic(575, 98, 711, 233, "bagM.png");
            }

        }.taskContent(mFairy, "定点挂机中");
    }//定点挂机



}
