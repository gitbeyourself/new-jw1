package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;

    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);

    }

    public void novice() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                result = mFairy.findPic(1,177,256,488,new String[]{"26.png"});//,"dzzx.png"
                if (result.sim > 0.85f) {
                    LtLog.e(mFairy.getLineInfo("主线结束"));
                    setTaskEnd();
                    return;
                }

                long dazeTime = mFairy.mMatTime(1154,153,73,16, 0.9f);
                LtLog.e("发呆时间"+dazeTime);

                result = mFairy.findPic(1,176,56,441, "zr2.png");
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                }
                if (dazeTime > 10) {

                    result = mFairy.findPic(1,177,256,488,new String[]{"18j.png","20j.png","djts.png"});
                    result1 = mFairy.findPic(758,298,934,411,"sy.png");
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic(1,177,256,488, "wxxs.png");
                        mFairy.onTap(0.7f, result, "你问我答", 500);

                        result = mFairy.findPic(1,177,256,488, "nwwd.png");
                        mFairy.onTap(0.7f, result, "你问我答", 500);

                        result = mFairy.findPic(1,177,256,488, new String[]{"zbqh.png","pfjs.png"});
                        mFairy.onTap(0.7f, result, "强化装备", 500);
                    }else if (result1.sim > 0.8f) {
                        result = mFairy.findPic(1099,640,1180,718, "sdzd.png");
                        mFairy.onTap(0.7f, result, "自动战斗", 500);

                        mFairy.onTap(0.8f, result1, "使用", 500);
                    }else{
                        result = mFairy.findPic(1, 176, 56, 441, "main.png");
                        mFairy.onTap(0.7f, result, "左侧主线", 500);
                        if (picCountS(0.7f, result, "左侧主线") > 30) {
                            LtLog.e(mFairy.getLineInfo("主线结束"));
                            setTaskEnd();
                            return;
                        }
                    }
                }

                result = mFairy.findPic(928,462,1247,705,"main1.png");
                mFairy.onTap(0.8f, result, "对话框主线", 500);

                result = mFairy.findPic(946,491,1230,568,"jsdh.png");
                mFairy.onTap(0.8f, result, "结束对话", 500);

                result = mFairy.findPic(906,553,1072,628,"qw.png");
                mFairy.onTap(0.8f, result, "前往", 500);

                result = mFairy.findPic(500,34,776,178,"duizhan.png");
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                    LtLog.e("对战中");
                    result = mFairy.findPic(1099,640,1180,718, "sdzd.png");
                    mFairy.onTap(0.7f, result, "自动战斗", 500);

                }

                result = mFairy.findPic(969,557,1179,670,"lkzc.png");
                mFairy.onTap(0.8f, result,  "离开战场", Sleep);

                result = mFairy.findPic(928,462,1247,705,new String[]{"zqhzb.png","dhkxz8.png"});
                mFairy.onTap(0.8f, result, "强化装备", 500);

                result = mFairy.findPic(928,462,1247,705,new String[]{"gsl.png","wxxs1.png","dhkxz1.png","dhkxz2.png","dhkxz3.png","dhkxz5.png","dhkxz6.png","dhkxz7.png","dhkxz9.png","dhkxz10.png"});//,"dhkxz4.png"
                mFairy.onTap(0.8f, result, "对话框选择", 500);

                result = mFairy.findPic(777,329,920,408,"Automatically put on.png");
                mFairy.onTap(0.8f, result, "自动穿上", Sleep);

                result = mFairy.findPic(433,116,814,308,"gxhd.png");
                mFairy.onTap(0.8f, result, 314,519,319,527, "恭喜获得", Sleep);


                result = mFairy.findPic(867,402,1055,500,"tijiao.png");
                mFairy.onTap(0.8f, result,  "提交", Sleep);

                result = mFairy.findPic(1087,25,1255,104,"tgzy.png");
                mFairy.onTap(0.8f, result,  "跳过指引", Sleep);

                result = mFairy.findPic(31,435,418,711,new String[]{"fsdlb.png","zhdlb.png","tiejiang.png"});
                if (result.sim>0.8f) {
                    result = mFairy.findPic(928,462,1247,705,"dhkxz4.png");
                    mFairy.onTap(0.8f, result,  "交易", Sleep);
                }

                result = mFairy.findPic(256,120,1059,499,"gmzy.png");
                if (result.sim>0.9f) {
                    mFairy.onTap(0.8f, result, "购买商品", Sleep);
                    mFairy.onTap(0.8f, result, 798, 499, 818, 510, "购买", Sleep);
                }

                result = mFairy.findPic(115,32,388,115,"dt.png");
                if (result.sim>0.8f) {
                    mFairy.onTap(0.8f, result, 715, 175, 729, 185, "默认第一个", Sleep);
                    result = mFairy.findPic(974,524,1121,620,"sd.png");
                    mFairy.onTap(0.8f, result,  "是的", Sleep);
                }

                result = mFairy.findPic(113,34,225,91,"bb.png");
                if (result.sim>0.8f) {
                    result = mFairy.findPic(362,165,630,534,"hd.png");
                    mFairy.onTap(0.8f, result,  "选择装备", 1000);
                    mFairy.onTap(0.8f, result,  921,476,927,484,"强化", 2000);
                    mFairy.onTap(0.8f, result,  978,594,989,603,"自动强化", Sleep);
                }

                result = mFairy.findPic(912,565,1051,630,"zdqh.png");
                if (result.sim>0.8f || dazeTime>60) {
                    gameUtil.close(0);
                }

            }
        }.taskContent(mFairy, "新手引导");
    }

    public void inOperation() throws Exception {

        result = mFairy.findPic(948,485,1226,684,"xyb.png");
        mFairy.onTap(0.8f, result, "下一步", 500);

        result = mFairy.findPic(836,675,953,719,"zdbf.png");
        mFairy.onTap(0.8f, result, "自动播放", 500);

        result =mFairy.findPic(40,468,401,702,"tcsq.png");
        mFairy.onTap(0.8f, result, "退出省电模式", 500);

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
        result = mFairy.findPic(540,84,732,186,"road.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("寻路中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(14,675,271,715,"dhk.png");
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }

    }

    public void bhcg() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("bhcg.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    ret = gameUtil.mission("bhcg.png", 1);
                    if (ret == 1) {
                        setTaskName(2);
                        return;
                    }else {
                        setTaskEnd();
                        return;
                    }
                }
            }

            public void content_2() throws Exception {
                if (overtime(30, 0)) {setTaskEnd(); return;}
                result = mFairy.findPic(427,433,851,573,"cgz.png");
                result = mFairy.findPic(868,134,1001,596,"cg.png");
                mFairy.onTap(0.8f, result, "传功", Sleep);
            }
        }.taskContent(mFairy, "帮会传功任务中");
    }//帮会传功任务中

    public void smrw() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("smrw.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    ret = gameUtil.mission("smrw1.png", 1);
                    if (ret == 1) {
                        setTaskName(2);
                        return;
                    }else {
                        setTaskEnd();
                        return;
                    }
                }
            }

            public void content_2() throws Exception {
                if (overtime(30, 0)) return;
                result = mFairy.findPic(944,489,1249,716,"smrw2.png");
                mFairy.onTap(0.8f, result, "师门任务", Sleep);

                result = mFairy.findPic(944,489,1249,716,new String[]{"rwss.png","dhkxz4.png"});
                mFairy.onTap(0.8f, result, "对话框选项", Sleep);

                result = mFairy.findPic(254,121,1059,482,"gmzy.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f, result,  "购买商品", Sleep);
                    mFairy.onTap(0.8f, result,  798,499,818,510,"购买", Sleep);
                }

                result = mFairy.findPic(867,402,1055,500,"tijiao.png");
                mFairy.onTap(0.8f, result,  "提交", Sleep);


            }//没有结束点
        }.taskContent(mFairy, "师门任务中");
    }//师门任务

    public void lmbj() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("lmbj.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    ret = gameUtil.mission("lmbj1.png", 1);
                    if (ret == 1) {
                        setTaskName(2);
                        return;
                    }else {
                        setTaskEnd();
                        return;
                    }
                }
            }

            public void content_2() throws Exception {
                result = mFairy.findPic(939,487,1226,710,"jsyb.png");
                mFairy.onTap(0.8f, result, "贡品征集", Sleep);

                result = mFairy.findPic(507,479,760,558,"ys.png");
                mFairy.onTap(0.8f, result, "押送镖车", Sleep);

                result = mFairy.findPic(939,487,1226,710,"jsbc.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, "接送镖车", 2000);
                    mFairy.onTap(0.8f, result, 1189,80,1196,89,"打开地图", Sleep);
                    mFairy.onTap(0.8f, result, 667,441,670,447,"地图坐标", 2000);
                    mFairy.onTap(0.8f, result, 649,426,655,430,"地图坐标", 2000);
                    mFairy.onTap(0.8f, result, 627,404,633,409,"地图坐标", 2000);
                    mFairy.onTap(0.8f, result, 620,379,626,384,"地图坐标", 2000);
                    mFairy.onTap(0.8f, result, 633,366,638,370,"地图坐标", 2000);
                    mFairy.onTap(0.8f, result, 614,345,621,349,"地图坐标", 2000);
                    mFairy.onTap(0.8f, result, 611,332,614,335,"地图坐标", 2000);
                    mFairy.onTap(0.8f, result, 643,307,647,311,"地图坐标", 2000);
                    mFairy.onTap(0.8f, result, 683,291,686,295,"地图坐标", 2000);
                    mFairy.onTap(0.8f, result, 689,280,694,283,"地图坐标", 2000);

                    result = mFairy.findPic(164,84,1115,658,"bjd.png");
                    mFairy.onTap(0.8f, result, "补给点", 2000);

                    mFairy.onTap(0.8f, result, 1105,56,1111,67,"关闭地图", Sleep);

                }
                result = mFairy.findPic(264,76,1032,653,"dh.png");
                mFairy.onTap(0.8f, result, "对话", Sleep);


            }

            public void content_3() throws Exception {
                if (overtime(20, 0)) return;
                result = mFairy.findPic("team.png");
                mFairy.onTap(0.95f, result, 15, 234, 29, 262, "在队伍栏切换到任务栏", Sleep);

                result = mFairy.findPic("task.png");
                mFairy.onTap(0.9f, result, 15, 234, 29, 262, "在任务栏打开任务框", Sleep);

                result = mFairy.findPic("yijie.png");
                mFairy.onTap(0.9f, result, "打开已接任务", Sleep);

                result = mFairy.findPic(94,17,244,84,"rwl2.png");
                mFairy.onTap(0.9f, result, 218,131,234,144,"主线收回", Sleep);

                result = mFairy.findPic(75,92,403,586,"xmrw1.png");
                mFairy.onTap(0.9f, result, "打开血盟任务", Sleep);

                result = mFairy.findPic(483, 558, 1095, 677, "tiaoguo.png");
                mFairy.onTap(0.8f, result, "跳过本环", Sleep);
                mFairy.onTap(0.8f, result, 362, 364, 376, 376, "跳过本环", Sleep);
                mFairy.onTap(0.8f, result, 758, 455, 792, 476, "跳过本环", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                }


            }

        }.taskContent(mFairy, "龙门镖局中");
    } //龙门镖局

    public void gpzj() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("gpzj.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    ret = gameUtil.mission("gpzj1.png", 1);
                    if (ret == 1) {
                        setTaskName(2);
                        return;
                    }else {
                        setTaskEnd();
                        return;
                    }
                }
            }
            public void content_2() throws Exception {
                if (overtime(60, 0)) return;
                result = mFairy.findPic(939,487,1226,710,"gpzj2.png");
                mFairy.onTap(0.8f, result, "贡品征集", Sleep);

                result = mFairy.findPic(939,487,1226,710,"sjgp.png");
                mFairy.onTap(0.8f, result, "上交", Sleep);


                result = mFairy.findPic(728,104,1063,420,"shangjiao.png");
                mFairy.onTap(0.8f, result, "提交", Sleep);

                result1 = mFairy.findPic(999,538,1023,570, "3.png");
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 980, 595, 997, 606, "完成任务", 1000);
                    setTaskEnd();
                    return;
                }

                result1 = mFairy.findPic(728,104,1063,420, "tj.png");
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1065,75,1079,87, "物品不足结束", 1000);
                    setTaskEnd();
                    return;
                }

            }
        }.taskContent(mFairy, "贡品征集");
    } //贡品征集

    public void keju2() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("mrdt.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    ret = gameUtil.mission("mrdt1.png", 1);
                    if (ret == 1) {
                        setTaskName(2);
                        return;
                    }else {
                        setTaskEnd();
                        return;
                    }
                }
            }

            public void content_2() throws Exception {
                if (overtime(30, 0)) return;
                result = mFairy.findPic(421,254,840,363,"mrdtts.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic(685,466,896,589,"qd.png");
                    mFairy.onTap(0.8f, result, "确定前往", Sleep);

                }

                result = mFairy.findPic(930,466,1245,702,"mrdtdh.png");
                mFairy.onTap(0.8f, result, "开始答题", Sleep);


                result = mFairy.findPic(612,4,1103,176,"activity.png");
                if (result.sim > 0.8f) {
                    LtLog.e("在桌面  重进");
                    setTaskName(1);
                }

                result = mFairy.findPic(115,32,388,115,"mrdt2.png");
                if (result.sim > 0.8f) {
                    LtLog.e("识别题目");
                    gameUtil.srAIAnswer();
                }

                result = mFairy.findPic(974,524,1121,620,"sd.png");
                mFairy.onTap(0.8f, result, "答题退出", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                }
            }
        }.taskContent(mFairy, "每日答题任务中");
    }//每日答题

}
