package com.script.fairy;

import android.graphics.Bitmap;
import android.util.Base64;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;

    public GameUtil(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        Sleep=1500;
        SleepWhile=1000;
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

    int tastState = 0;
    public int mission(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;


            public void content_0() throws Exception {
                close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic(1053,1,1101,88,"hdkzl.png");
                mFairy.onTap(0.8f, result, "活动展开", Sleep);

                result = mFairy.findPic(612,4,1103,176,"activity.png");
                mFairy.onTap(0.8f, result, "活动", Sleep);

                result = mFairy.findPic(44,4,194,65,new String[]{"Activeinterface.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(2000);
                    result1 = mFairy.findPic(448,547,1055,576,"hd.png");
                    LtLog.e("相似度1"+result1.sim);
                    mFairy.onTap(0.8f, result1, result1.x-30,result1.y+20,result1.x-27,result1.y+23,"领取活跃奖励栏", Sleep);
                    if (result1.sim > 0.8f){
                        for (int i=0;i<4;i++){
                            result = mFairy.findPic(572,421,713,491,"lq1.png");
                            mFairy.onTap(0.8f, result, "奖励领取确认", Sleep);
                            result = mFairy.findPic(448,547,1055,576,"hd.png");
                            LtLog.e("相似度2"+result.sim);
                            mFairy.onTap(0.9f, result, result.x-30,result.y+20,result.x-27,result.y+23,"领取活跃奖励栏", Sleep);
                            if (result.sim>0.9f){
                                i=0;
                            }
                        }
                    }else{
                        mFairy.condit();
                        result = mFairy.findPic(667,48,1188,473, str);
                        if (result.sim > 0.8f) {
                        } else {
                            if (option == 1) {
                                mFairy.onTap(97,107,137,121, "单人", Sleep);
                            }
                            if (option == 2) {
                                mFairy.onTap(97,158,138,175, "组队", Sleep);
                            }
                            if (option == 3) {
                                mFairy.onTap(93,209,144,228, "定时", Sleep);
                            }
                        /*findtask++;
                            setTaskName(3);
                            return;*/
                            if (option == 4) {
                                mFairy.onTap(95,260,145,281, "周历", Sleep);
                            }
                        }
                        findtask++;
                        setTaskName(2);
                        return;
                    }

                }
            }

            public void content_2() throws Exception {
                if (overtime(12, 0)) return;
                result = mFairy.findPic(44,4,194,65,new String[]{"Activeinterface.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动界面"));
                if (result.sim > 0.8f) {
                    result1 = mFairy.findPic(667,48,1188,473, str);
                    LtLog.e("任务相似度=" + str + "---" + result1.sim);
                    if (result1.sim > 0.8f) {
                        result = mFairy.findPic(result1.x + 253, result1.y + 23, result1.x + 349, result1.y + 68, new  String[]{"canjia.png","canjia1.png"});
                        if (result.sim >= 0.8f) {
                            mFairy.onTap(0.8f, result, "参加任务", 500);
                            result = mFairy.findPic(324,167,949,285, new  String[]{"wkq.png"});
                            if (result.sim >= 0.8f) {
                                GameUtil.this.tastState = 0;
                                setTaskEnd();
                                return;
                            }
                            GameUtil.this.tastState = 1;
                            setTaskEnd();
                            return;
                        }

                        result = mFairy.findPic(result1.x + 253, result1.y + 23, result1.x + 349, result1.y + 68, new  String[]{"wancheng.png"});
                        mFairy.onTap(0.8f, result, 1203,31,1214,46, "日常完成", Sleep);
                        if (result.sim >= 0.8f) {
                            GameUtil.this.tastState = 0;
                            setTaskEnd();
                            return;
                        }

                        result = mFairy.findPic(result1.x + 253, result1.y + 23, result1.x + 349, result1.y + 68, new  String[]{"kong.png"});
                        mFairy.onTap(0.8f, result, 1203,31,1214,46, "无法参加", Sleep);
                        if (result.sim >= 0.8f) {
                            GameUtil.this.tastState = 0;
                            setTaskEnd();
                            return;
                        }
                    }else {
                        mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0, 911, 454, 921, 181, 1000, 1500, 2);
                    }
                }
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }//开始任务


    public void close(final int close) throws Exception {
        new GameUtil(mFairy) {
            int j = 1;
            public void content_0() throws Exception {
                if (Thread.currentThread().isInterrupted()){
                    throw new InterruptedException();
                }

                for (int i = 0; i < j; i++) {
                    mFairy.condit();
                    if (close == 1) {

                        result = mFairy.findPic(389, 458, 876, 526, new String[]{"NoBattle.png", "NoBattle3.png"});
                        if (result.sim > 0.8f){
                            mFairy.onTap(1133, 329, 1141, 337, "关闭自动战斗", Sleep);
                        }

                        result = mFairy.findPic(1099, 277, 1173, 348, "1/NoBattle.png");
                        if (result.sim > 0.8f) {
                            j = 2;
                        } else {
                            j = 15;
                        }
                    }

                    result = mFairy.findPic(14,675,271,715,"dhk.png");
                    mFairy.onTap(0.8f, result, 1187,72,1200,94,"对话框关闭", 500);

                    result = mFairy.findPic(849,610,1078,711, "lk1.png");
                    mFairy.onTap(0.8f, result, "离开", 1000);

                    result = mFairy.findPic(571,4,1278,524, new String[]{"cha1.png","cha2.png"});//"ymzjcha.png",
                    mFairy.onTap(0.8f, result, "关叉", 500);

                    result = mFairy.findPic( 420,254,826,396, "tzjs.png");
                    mFairy.onTap(0.7f, result, 628,502,645,513,"挑战结束", 500);

                    if (result.sim > 0.8f) {
                        j = 15;
                    } else {
                        j = 2;
                    }


                    result =mFairy.findPic(40,468,401,702,new String[]{"tcsq.png","jstg.png"});
                    mFairy.onTap(0.8f, result, "退出省电模式", 500);


                    result =mFairy.findPic(40,468,401,702,new String[]{"jstg.png"});
                    if (result.sim > 0.8f) {
                        mFairy.onTap(1188,78,1195,90,"结束托管  地图", 1000);

                        result = mFairy.findPic(838,581,1123,666,"sj.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, "世界", Sleep);

                            result =mFairy.findPic(665,303,838,413,"zuobiao.png");
                            if (result.sim > 0.8f) {
                                mFairy.onTap(725,247,730,260, "人物在襄阳切换地图", 5000);
                            }else{
                                mFairy.onTap(748,349,756,360, "回襄阳 切换地图", 5000);
                            }
                        }
                    }
                }
                setTaskEnd();
                return;
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }//关叉

    public void setUp() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(10, 0)) return;
                result = mFairy.findPic(1087,251,1274,616,"chengjiu.png");
                if (result.sim>=0.8f) {
                    mFairy.onTap(1224,538,1232,545, "设置", Sleep);
                }else{
                    mFairy.onTap(1224,300,1231,309, "展开", Sleep);
                }

                result = mFairy.findPic(76,17,228,84,"Set up inface.png");
                mFairy.onTap(0.8f, result, 174,116,198,127, "设置界面", Sleep);
                mFairy.onTap(0.8f, result, 563,431,572,443, "低画质", Sleep);
                mFairy.onTap(0.8f, result, 1177,50,1186,66, "关闭", Sleep);
                if (result.sim>=0.8f){
                    setTaskEnd();
                    return;
                }

            }

        }.taskContent(mFairy, "设置中");
    }//设置

    public void setUp1() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {

                result = mFairy.findPic(186,43,1117,644,new String[]{"jt.png","jt2.png"});
                mFairy.onTap(0.8f, result, "地面箭头", 500);


            }

        }.taskContent(mFairy, "设置中");
    }//设置

    int cityCount;
    int x;

    public int goCity(Integer i) throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                if (overtime(4, 0)) return;

                result = mFairy.findPic(1053,1,1101,88,"hdkzl.png");
                mFairy.onTap(0.8f, result, "活动展开", Sleep);

                result = mFairy.findPic(612,4,1103,176,"activity.png");
                mFairy.onTap(0.8f, result, 1188,83,1193,93, "打开地图", 3000);

                result = mFairy.findPic(856,579,1121,670,"hcWorld.png");
                if (result.sim>0.8f){
                    setTaskName(2);
                    return;
                }

            }

            public void content_2() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic(856,579,1121,670,"hcWorld.png");
                mFairy.onTap(0.8f, result,  "打开世界", 3000);

                result = mFairy.findPic(99,13,477,118,"shsjt.png");
                if (result.sim>0.8f) {
                    switch (i) {
                        case 1:
                            mFairy.onTap(680,166,35, 15, "少林", Sleep);
                            break;
                        case 2:
                            mFairy.onTap(714,511,35, 15, "天王帮", Sleep);

                            break;
                        case 3:
                            mFairy.onTap(376,534,40, 15, "唐门", Sleep);

                            break;
                        case 4:
                            mFairy.ranSwipe(1083,551,1083,151,1000, (long) 1400,2);
                            mFairy.onTap(803,516,40, 15, "五毒", Sleep);

                            break;
                        case 5:
                            mFairy.onTap(225,575,40, 15, "峨眉", Sleep);

                            break;
                        case 6:
                            mFairy.ranSwipe(1083,551,1083,151,1000, (long) 1400,2);
                            mFairy.onTap(622,562,40, 15, "翠烟", Sleep);

                            break;
                        case 7:
                            mFairy.onTap(922,370,40, 15, "丐帮", Sleep);

                            break;
                        case 8:
                            mFairy.onTap(837,306,40, 15, "天忍教", Sleep);

                            break;
                        case 9:
                            mFairy.onTap(591,247,40, 15, "武当", Sleep);

                            break;
                        case 10:
                            mFairy.onTap(219,192,40, 15, "昆仑", Sleep);

                            break;
                        case 11:

                            mFairy.onTap(495,117, 35, 15, "风陵渡渡口", Sleep);

                            break;
                        case 12:
                            mFairy.ranSwipe(1083,151,1083,551,1000, (long) 1400,2);
                            mFairy.onTap(738,216,40, 15, "漠北草原180", Sleep);

                            break;
                        case 13:
                            mFairy.onTap(426,460,40, 15, "剑门关160", Sleep);
                            break;
                        case 14:
                            mFairy.ranSwipe(1083,551,1083,151,1000, (long) 1400,2);
                            mFairy.onTap(372,510,40, 15, "千寻塔140", Sleep);

                            break;
                        case 15:
                            mFairy.onTap(874,119,40, 15, "长白山120", Sleep);

                            break;
                        case 16:
                            mFairy.ranSwipe(1083,151,1083,551,1000, (long) 1400,2);
                            mFairy.onTap(302,186,40, 15, "沙漠山洞100", Sleep);

                            break;
                        case 17:
                            mFairy.onTap(811,564,40, 15, "青螺岛100", Sleep);

                            break;
                        case 18:
                            mFairy.onTap(188,371,40, 15, "老虎洞80", Sleep);

                            break;
                        case 19:
                            mFairy.onTap(486,597,40, 15, "桃花源80", Sleep);

                            break;
                        case 20:
                            mFairy.onTap(365,211,40, 15, "药王谷60", Sleep);

                            break;
                        case 21:
                            mFairy.onTap(365,211,40, 15, "莫高窟60", Sleep);

                            break;
                        case 22:
                            mFairy.onTap(430,288,40, 15, "秦始皇陵60", Sleep);

                            break;
                        case 23:
                            mFairy.onTap(960,255,40, 15, "古战场60", Sleep);

                            break;
                        case 24:
                            mFairy.onTap(846,205,40, 15, "临渝关40", Sleep);

                            break;
                        case 25:
                            mFairy.onTap(469,387,40, 15, "华山40", Sleep);

                            break;
                        case 26:
                            mFairy.onTap(604,354,40, 15, "火狼词40", Sleep);

                            break;
                        case 27:
                            mFairy.onTap(974,610,40, 15, "武夷山40", Sleep);

                            break;
                        case 28:
                            mFairy.onTap(337,369,40, 15, "响水洞20", Sleep);

                            break;
                        case 29:
                            mFairy.onTap(251,469,40, 15, "青城山20", Sleep);

                            break;
                        case 30:
                            mFairy.onTap(622,436,40, 15, "伏牛山20", Sleep);

                            break;
                        case 31:
                            mFairy.onTap(847,437,40, 15, "荐菊洞20", Sleep);

                            break;
                        case 32:
                            mFairy.ranSwipe(1083,551,1083,151,1000, (long) 1400,2);
                            mFairy.onTap(242,554,40, 15, "点苍山20", Sleep);

                            break;
                        case 50:
                            mFairy.onTap(755,363,757,363, "襄阳", Sleep);
                            break;
                    }


                    close(1);
                    setTaskName(3);
                    return;
                }

            }

            public void content_3() throws Exception {
                int tu1=0;

                result = mFairy.findPic(1053,1,1101,88,"hdkzl.png");
                mFairy.onTap(0.8f, result, "活动展开", Sleep);

                result = mFairy.findPic(612,4,1103,176,"activity.png");
                mFairy.onTap(0.8f, result, 1188,83,1193,93, "打开地图", 3000);

                //查看当前的位置
                result = mFairy.findPic(856,579,1121,670,"hcWorld.png");
                if (result.sim > 0.8f) {
                    LtLog.e("地图内");
                    Thread.sleep(2000);

                    if (i==14){
                        result1 = mFairy.findPic(459,244,809,469,new String[]{"tn.png","dcs.png"});
                        mFairy.onTap(0.8f, result, 696,346,702,347, "去塔内", 20000);
                        result = mFairy.findPic(612,4,1103,176,"activity.png");
                        mFairy.onTap(0.8f, result, 1188,83,1193,93, "打开地图", 3000);
                    }

                    mFairy.condit();
                    for (int i = 1; i < 32; i++) {
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
                                    LtLog.e(mFairy.getLineInfo("古战场60"));
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
                                case 50:
                                    LtLog.e(mFairy.getLineInfo("襄阳"));
                                    tu1 = 50;
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
                    if (tu1==0 || i != tu1) {

                        LtLog.e(mFairy.getLineInfo("不在一个地图"));
                        setTaskName(2);
                        return;
                    }else{
                        if (tu1==22){
                            mFairy.onTap(664,347,668,351, "天王帮", Sleep);
                        }
                        LtLog.e(mFairy.getLineInfo("到达目的地"));
                        setTaskEnd();
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "传送城市中");
        return cityCount;
    }//传送城市

    //一键喊话
    public void yjhh() throws Exception {
        LtLog.e(mFairy.getLineInfo("一键喊话中"));
        result = mFairy.findPic(490,579,627,646,"hh.png");
        mFairy.onTap(0.8f, result, "一键喊话", Sleep);

        result = mFairy.findPic(397,198,906,516, "hhzm.png");
        mFairy.onTap(0.8f, result, 683,329,690,338,"好友频道", 500);
        mFairy.onTap(0.8f, result, 493,378,505,390,"帮会频道", 500);
        mFairy.onTap(0.8f, result, 677,377,690,389,"附近频道", 500);
        mFairy.onTap(0.8f, result, 626,446,653,467,"附近频道", 500);

    }

    public void coordinate(Integer i, final int gmx, final int gmy) throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                result = mFairy.findPic(856,579,1121,670,"hcWorld.png");
                if (result.sim > 0.8f) {
                }else {
                    close(1);
                }
                setTaskName(1);
                return;
            }

            double x;
            double y;

            public void content_1() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic(612,4,1103,176, "activity.png");
                mFairy.onTap(0.8f, result, 1181, 71, 1203, 90, "打开地图", Sleep);


                result = mFairy.findPic("hcWorld.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("地图界面=" + i));
                    Thread.sleep(2000);
                    switch (i) {
                        case 1:
                            LtLog.e(mFairy.getLineInfo("少林"));
                            x=gmx *3.9736+gmy *0.0185+227.8297;
                            y=gmx *0.0049+gmy *-2.028+579.3062;
                            break;
                        case 2:
                            LtLog.e(mFairy.getLineInfo("天王帮"));
                            x=gmx *4.0088+gmy *0.0065+254.625;
                            y=gmx *-0.0097+gmy *-2.0147+578.625;
                            break;
                        case 3:
                            LtLog.e(mFairy.getLineInfo("唐门"));
                            x=gmx *3.9836+gmy *0.0045+289.3693;
                            y=gmx *-0.0113+gmy *-2.0056+642.6215;
                            break;
                        case 4:
                            LtLog.e(mFairy.getLineInfo("五毒"));
                            x=gmx *3.9962+gmy *-0.0078+226.6052;
                            y=gmx *0.0076+gmy *-1.9843+606.7896;
                            break;
                        case 5:
                            LtLog.e(mFairy.getLineInfo("峨眉"));
                            x=gmx *4.7065+gmy *-1.6087+362.913;
                            y=gmx *-2.5375+gmy *4.038+205.9697;
                            break;
                        case 6:
                            LtLog.e(mFairy.getLineInfo("翠烟"));
                            x=gmx *3.012+gmy *2.491+-249.4467;
                            y=gmx *-0.0024+gmy *-1.7817+653.4277;
                            break;
                        case 7:
                            LtLog.e(mFairy.getLineInfo("丐帮"));
                            x=gmx *4.0163+gmy *0.0119+415.1128;
                            y=gmx *0.023+gmy *-2.0124+577.3627;
                            break;
                        case 8:
                            LtLog.e(mFairy.getLineInfo("天忍教"));
                            x=gmx *4.0421+gmy *0.0356+396.1194;
                            y=gmx *0.0015+gmy *-2.0244+498.6441;
                            break;
                        case 9:
                            LtLog.e(mFairy.getLineInfo("武当"));
                            x=gmx *4.0191+gmy *-0.0066+368.9245;
                            y=gmx *-0.02+gmy *-2.005+531.46;
                            break;
                        case 10:
                            LtLog.e(mFairy.getLineInfo("昆仑"));
                            x=gmx *3.7761+gmy *-0.0078+220.617;
                            y=gmx *-0.0158+gmy *-1.902+645.9026;
                            break;
                        case 11:
                            LtLog.e(mFairy.getLineInfo("风陵渡渡口"));
                            x=gmx *3.9943+gmy *-0.0079+370.8078;
                            y=gmx *0.0126+gmy *-1.9996+574.7379;
                            break;
                        case 12:
                            LtLog.e(mFairy.getLineInfo("漠北草原180"));
                            x=gmx *3.5226+gmy *-0.0053+402.7084;
                            y=gmx *0.013+gmy *-1.754+606.3604;
                            break;
                        case 13:
                            LtLog.e(mFairy.getLineInfo("剑门关160"));
                            x=gmx *3.6004+gmy *0.0118+336.2775;
                            y=gmx *-0.0916+gmy *-1.7467+653.4669;
                            break;
                        case 14:
                            LtLog.e(mFairy.getLineInfo("千寻塔140"));
                            x=gmx *4.0181+gmy *0.0064+302.7006;
                            y=gmx *-0.011+gmy *-2.0136+530.8347;
                            break;
                        case 15:
                            LtLog.e(mFairy.getLineInfo("长白山120"));
                            x=gmx *3.2412+gmy *0.0064+406.8172;
                            y=gmx *0.0214+gmy *-1.6218+615.387;
                            break;
                        case 16:
                            LtLog.e(mFairy.getLineInfo("沙漠山洞100"));
                            x=gmx *4.0178+gmy *-0.0138+375.1828;
                            y=gmx *0.0079+gmy *-1.9843+548.4615;
                            break;
                        case 17:
                            LtLog.e(mFairy.getLineInfo("青螺岛100"));
                            x=gmx *3.6189+gmy *0.0101+291.3675;
                            y=gmx *-0.0113+gmy *-1.7961+600.5108;
                            break;
                        case 18:
                            LtLog.e(mFairy.getLineInfo("老虎洞80"));
                            x=gmx *4.0177+gmy *0.0241+382.6332;
                            y=gmx *0.0005+gmy *-2.0279+532.5324;
                            break;
                        case 19:
                            LtLog.e(mFairy.getLineInfo("桃花源80"));
                            x=gmx *4.0096+gmy *0.0123+334.9857;
                            y=gmx *0.0125+gmy *-2.0141+658.7947;
                            break;
                        case 20:
                            LtLog.e(mFairy.getLineInfo("药王谷60"));
                            x=gmx *4.0241+gmy *-0.0128+273.6588;
                            y=gmx *0.016+gmy *-2.0086+609.1059;
                            break;
                        case 21:
                            LtLog.e(mFairy.getLineInfo("莫高窟60"));
                            x=gmx *3.9902+gmy *-0.0136+325.0356;
                            y=gmx *-0.0087+gmy *-2.0409+566.5027;
                            break;
                        case 22:
                            LtLog.e(mFairy.getLineInfo("秦始皇陵60"));
                            x=gmx *3.989+gmy *0.022+320.7802;
                            y=gmx *0.0007+gmy *-2.0099+514.1243;
                            break;
                        case 23:
                            LtLog.e(mFairy.getLineInfo("古战场80"));
                            x=gmx *4.0215+gmy *-0.0007+287.2059;
                            y=gmx *0.0352+gmy *-2.0224+624.0608;
                            break;
                        case 24:
                            LtLog.e(mFairy.getLineInfo("临渝关40"));
                            x=gmx *4.0162+gmy *-0.0065+241.8524;
                            y=gmx *0.0098+gmy *-2.0189+659.8089;
                            break;
                        case 25:
                            LtLog.e(mFairy.getLineInfo("华山40"));
                            x=gmx *4.0133+gmy *-0.0175+369.7407;
                            y=gmx *0.0001+gmy *-1.9905+559.347;
                            break;
                        case 26:
                            LtLog.e(mFairy.getLineInfo("火狼词40"));
                            x=gmx *3.9919+gmy *0.0118+352.0925;
                            y=gmx *-0.0004+gmy *-2.0061+577.0721;
                            break;
                        case 27:
                            LtLog.e(mFairy.getLineInfo("武夷山40"));
                            x=gmx *4.0+gmy *0.0+273.0;
                            y=gmx *-0.0015+gmy *-2.0123+627.6626;
                            break;
                        case 28:
                            LtLog.e(mFairy.getLineInfo("响水洞20"));
                            x=gmx *4.0003+gmy *0.0066+337.9247;
                            y=gmx *-0.0102+gmy *-2.0031+545.7046;
                            break;
                        case 29:
                            LtLog.e(mFairy.getLineInfo("青城山20"));
                            x=gmx *4.0162+gmy *-0.009+401.4169;
                            y=gmx *0.0145+gmy *-2.0029+609.3018;
                            break;
                        case 30:
                            LtLog.e(mFairy.getLineInfo("伏牛山20"));
                            x=gmx *4.0071+gmy *-0.0139+291.302;
                            y=gmx *-0.0+gmy *-2.0+610.0;
                            break;
                        case 31:
                            LtLog.e(mFairy.getLineInfo("荐菊洞20"));
                            x=gmx *4.0244+gmy *0.011+352.4088;
                            y=gmx *-0.0018+gmy *-2.0182+578.67;
                            break;
                        case 32:
                            LtLog.e(mFairy.getLineInfo("点苍山20"));
                            x=gmx *3.7761+gmy *-0.0078+220.617;
                            y=gmx *-0.0158+gmy *-1.902+645.9026;
                            break;
                    }
                    LtLog.e("szmap=="+ LimitlessTask.szmap);
                    mFairy.tap((int) x, (int) y);
                    LtLog.e(mFairy.getLineInfo("点击屏幕坐标x=" + (int) x + ",y=" + (int) y));
                    LtLog.e("设定坐标：gmx"+gmx+"---gmy"+gmy);
                    close(1);
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                //坐标三秒没变,则到达坐标点
                long dazeTime = mFairy.mMatTime(1154,153,73,16, 0.9f);
                LtLog.e("发呆时间"+dazeTime);
                if (dazeTime > 3) {
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("到达目的地"));
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "定位坐标中");
    }//定位坐标


    public  void  cifu()throws Exception{
        new GameUtil(mFairy){
            @Override
            public void content_0() throws Exception {
                 close(0);
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(10,0))return;
                result = mFairy.findPic(612,4,1103,176, "activity.png");
                mFairy.onTap(0.8f, result, 1074,34,1085,49, "日常", Sleep);


                result = mFairy.findPic(876, 5, 1120, 146, "welfare.png");
                mFairy.onTap(0.8f, result, "福利", Sleep);

                result = mFairy.findPic(104,21,277,85,new String[]{"WelfareInterface.png","WelfareInterface1.png","WelfareInterface2.png","WelfareInterface3.png" });
                if (result.sim>0.8f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(3,99)){close(0);return;}

                result = mFairy.findPic(13,16,505,710,"cifu.png");
                mFairy.onTap(0.8f, result, "赐福", Sleep);

                result = mFairy.findPic(619,604,851,684,new  String[]{"jpReceive.png","jpReceive1.png" });
                mFairy.onTap(0.8f, result, "领取", Sleep);
            }
        }.taskContent(mFairy,"赐福中");
    }//赐福


    public  void  fuli()throws Exception{
        new SingleTask(mFairy){
            int i=0;
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(10,0))return;

                result = mFairy.findPic(1053,1,1101,88,"hdkzl.png");
                mFairy.onTap(0.8f, result, "活动展开", Sleep);

                result = mFairy.findPic(612,4,1103,176,"activity.png");
                mFairy.onTap(0.8f, result, 761,113,771,128,"活动", Sleep);

                result = mFairy.findPic(72,11,254,125, "fuli.png");
                if (result.sim>0.7f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(10,3))return;
                result = mFairy.findPic(74,118,277,635,"qdlj.png");
                mFairy.onTap(0.8f, result, "签到领奖", Sleep);

                result = mFairy.findPic( 926,575,1114,664,"qiandao.png");
                mFairy.onTap(0.8f, result, "签到", Sleep);

                result = mFairy.findPic( 398,152,891,282,"wflq.png");
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }
            }
            public void content_3() throws Exception {
                if (overtime(10,4))return;

                result = mFairy.findPic(74,118,277,635,"yqs.png");
                mFairy.onTap(0.8f, result, "摇钱树", Sleep);


                result = mFairy.findPic( 957,458,1118,557,"mf.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f, result,1030,519,1052,530, "摇一摇", Sleep);
                }else{
                    setTaskName(4);return;
                }


            }
            public void content_4() throws Exception {
                if (overtime(10, 5))return;

                result = mFairy.findPic(74,118,277,635,"lxtg.png");
                mFairy.onTap(0.8f, result, "离线托管", Sleep);

                result = mFairy.findPic(438,486,703,626,"lq2.png");
                mFairy.onTap(0.8f, result, "领取", Sleep);

                result = mFairy.findPic(703,471,880,545,"qd1.png");
                mFairy.onTap(0.8f, result, "领取确定", Sleep);
                if (result.sim > 0.8f){
                    setTaskName(5);return;
                }

            }
            public void content_5() throws Exception {
                if (overtime(30, 5)) {
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic(74,118,277,635,"jlzh.png");
                mFairy.onTap(0.8f, result, "离线托管", Sleep);

                result = mFairy.findPic(787,88,1141,181,"ptzh.png");
                if (result.sim>0.8f) {
                    mFairy.onTap(0.8f, result, "普通找回", Sleep);
                    i=1;
                }
                if (i!=0){
                    result = mFairy.findPic(952,168,1121,503,"zhaohui.png");
                    mFairy.onTap(0.8f, result, "找回", Sleep);
                }

                result = mFairy.findPic(405,211,917,571,"qd2.png");
                mFairy.onTap(0.8f, result, "找回确定", Sleep);


                result = mFairy.findPic(868,172,1139,279,"yzh.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, 1173,73,1186,91,"关闭窗口", Sleep);
                    setTaskEnd();
                    return;
                }

            }
        }.taskContent(mFairy,"福利任务中");
    }//福利

    //退队
    public void retire() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(15, 0)) return;

                result = mFairy.findPic(3,113,263,186,"duiwulan.png");
                mFairy.onTap(0.8f, result, "切换到队伍栏", Sleep);

                result = mFairy.findPic(3,113,263,186,"duiwu2.png");
                mFairy.onTap(0.8f, result, "切换到队伍栏", Sleep);

                result = mFairy.findPic(342,557,490,649,"lkdw.png");
                mFairy.onTap(0.8f, result,"离开队伍", Sleep);

                result = mFairy.findPic(2,125,255,349,"chuanjianduiwu.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("没有队伍退队结束"));
                    setTaskName(2);
                    return;
                }

                result = mFairy.findPic(633,306,903,430,"zwdw.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("没有队伍退队结束"));
                    setTaskName(2);
                    return;
                }

                result = mFairy.findPic(846,565,1201,670,"cjdw.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("没有队伍退队结束"));
                    setTaskName(2);
                    return;
                }

                result = mFairy.findPic(329,159,953,561,"tcdqdw.png");
                mFairy.onTap(0.8f, result, 774,504,795,517, "确定离开队伍", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                close(0);
                setTaskEnd();
                return;
            }

        }.taskContent(mFairy, "退队中");
    }

    public  void  moshi()throws Exception{
        if (AtFairyConfig.getOption("hpms").equals("1")) {
            result = mFairy.findPic(64,30,206,81,"paishe.png");
            result1 = mFairy.findPic(64,30,206,81,"liangong.png");
            if (result.sim > 0.8f && result1.sim < 0.8f) {
                mFairy.onTap(0.8f, result, 141,51,161,55,"切换下模式", Sleep);
                mFairy.onTap(0.8f, result, 211,48,228,54, "练功模式", Sleep);
            }
        }
        if (AtFairyConfig.getOption("hpms").equals("2")) {
            result = mFairy.findPic(64,30,206,81,"paishe.png");
            result1 = mFairy.findPic(64,30,206,81,"zhandou.png");
            if (result.sim > 0.8f && result1.sim < 0.8f) {
                mFairy.onTap(0.8f, result, 141,51,161,55,"切换下模式", Sleep);
                mFairy.onTap(0.8f, result, 281,48,293,56, "战斗模式", Sleep);
            }
        }

        if (AtFairyConfig.getOption("hpms").equals("3")) {
            result = mFairy.findPic(64,30,206,81,"paishe.png");
            result1 = mFairy.findPic(64,30,206,81,"hunzhan.png");
            if (result.sim > 0.8f && result1.sim < 0.8f) {
                mFairy.onTap(0.8f, result, 141,51,161,55,"切换下模式", Sleep);
                mFairy.onTap(0.8f, result, 355,48,362,58, "混战模式", Sleep);
            }
        }

    }//切换模式


    public void srAIAnswer() throws Exception {
        List<String> answerStrABCD = new ArrayList();

        String mStr = getPictureText(162,162,500,100);//题目范围x,y,w,h
        LtLog.e(this.mFairy.getLineInfo("题目是=" + mStr));
        if (mStr == null || mStr.equals("")) {
            this.mFairy.onTap(701,168,731,198, "没有识别到题目,默认选A", 1000);
            //mFairy.onTap(895, 579, 935, 588, "", 3000);
        } else {
            answerStrABCD.add(getPictureText(743,163,320,40));//A范围x,y,w,h
            answerStrABCD.add(getPictureText(746,288,320,40));//B范围x,y,w,h

            String c = getPictureText(744,418,320,40);
            if (!c.equals("")) {
                answerStrABCD.add(c);//C范围x,y,w,h
            }
            String d = getPictureText(743,539,320,40);
            if (!d.equals("")) {
                answerStrABCD.add(d);//C范围x,y,w,h
            }

            String[] answer = this.findAnswer(mStr, AtFairyConfig.getGameID());
            if (answer != null) {
                LtLog.e(mFairy.getLineInfo("开始匹配答案："));
                for (int j = 0; j < answerStrABCD.size(); ++j) {
                    LtLog.e(j + " : " + answerStrABCD.get(j));

                    for (int i = 0; i < answer.length; ++i) {
                        if (answerStrABCD.get(j).equals(answer[i])) {
                            switch (j) {
                                case 0:
                                    mFairy.onTap(702,172,732,196, "匹配到正确答案A", 1000);
                                    break;
                                case 1:
                                    mFairy.onTap(701,295,732,322, "匹配到正确答案B", 1000);
                                    break;
                                case 2:
                                    mFairy.onTap(702,419,730,447, "匹配到正确答案C", 1000);
                                    break;
                                case 3:
                                    mFairy.onTap(702,544,731,573, "匹配到正确答案D", 1000);
                                    break;
                            }
                            mFairy.onTap(1024,174,1036,189, "", 3000);
                            return;
                        }
                    }
                }
            }

            LtLog.e(this.mFairy.getLineInfo("没有匹配到,开始上传"));
            LtLog.i(this.mFairy.getLineInfo("----------------------------upDown>"));
            String answerStr = "";
            this.mFairy.onTap(704,170,727,194, "A", 1000);
            for (int i = 0; i < 10; ++i) {
                result = this.mFairy.findPic(1017,120,1140,249, "str1.png");
                if (result.sim > 0.88f) {
                    answerStr = answerStrABCD.get(0);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---A---" + answerStr));
                    break;
                }

                result = this.mFairy.findPic(1012,248,1133,374, "str1.png");
                if (result.sim > 0.88f) {
                    answerStr = answerStrABCD.get(1);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---B---" + answerStr));
                    break;
                }

                result = this.mFairy.findPic(1035,375,1134,498, "str1.png");
                if (result.sim > 0.88f) {
                    answerStr = answerStrABCD.get(2);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---C---" + answerStr));
                    break;
                }

                result = this.mFairy.findPic(1032,499,1136,623, "str1.png");
                if (result.sim > 0.88f) {
                    answerStr = answerStrABCD.get(3);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---D---" + answerStr));
                    break;
                }
                Thread.sleep(200);
            }

            if (answerStr != "") {
                this.UpAnswerAndTitle(mStr, answerStr, AtFairyConfig.getGameID());
            }
        }
    }


    public String bitmapToBase64(Bitmap bitmap, int quality) {
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String trWebOCR(String url, Bitmap bitmap) {
        String result = null;
        String imgBase64 = bitmapToBase64(bitmap, 50);
        try {
            FormBody.Builder builder = new FormBody.Builder();

            builder.add("img", imgBase64);
            RequestBody formBody = builder.build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                result = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getPictureText(int x, int y, int width, int height) {
        //331, 165, 811, 109
        Mat mat = mFairy.getScreenMat(x, y, width, height, 1, 0, 0, 1);
        Bitmap bmpCanny = Bitmap.createBitmap(mat.cols(), mat.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(mat, bmpCanny);

        String str = trWebOCR("http://192.168.1.254:8089/api/tr-run/", bmpCanny);
        if (str == null || str.equals("")) {
            return "";
        }

        LtLog.e("trWebOCR :" + str);

        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) new JSONObject(new JSONObject(str).get("data").toString()).get("raw_out");
            String mStr = new JSONArray(jsonArray.get(0).toString()).get(1).toString();
            return mStr;
        } catch (JSONException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return "";
    }

    private String[] findAnswer(String title, String game_id) throws Exception {
        OkHttpClient client = new OkHttpClient();
        String resultStr = null;
        Request request = (new Request.Builder()).url("http://API.padyun.com/Yunpai/V1/IntelligentAnswer/FindTheAnswer?title=" + title + "&game_id=" + game_id).get().build();
        Response response = client.newCall(request).execute();
        resultStr = response.body().string();
        resultStr = (new JSONTokener(resultStr)).nextValue().toString();
        JSONObject jsonObject = new JSONObject(resultStr);
        if (jsonObject.getString("data").equals("false")) {
            LtLog.i(this.mFairy.getLineInfo("-----------+++---------not title"));
            return null;
        } else {
            String arr = jsonObject.getString("data").replaceAll("\\[", "");
            arr = arr.replaceAll("\\]", "");
            arr = arr.replaceAll("\"", "");
            String[] array = arr.split(",");
            LtLog.i(this.mFairy.getLineInfo("-----------+++---------array=" + array));
            return array;
        }
    }

    private void UpAnswerAndTitle(String title, String answer, String game_id) throws InterruptedException {
        String resultStr = null;
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "title=" + title + "&game_id=" + game_id + "&answer=" + answer);
        Request request = (new Request.Builder()).url("http://API.padyun.com/Yunpai/V1/IntelligentAnswer/AddTitle").post(body).build();

        try {
            Response response = client.newCall(request).execute();
            resultStr = response.body().string();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

        Thread.sleep(100L);
    }

    /*public static void main(String[] args) {
        int b = decrf(4);
        System.out.println(b);
    }

    public static int decrf(int n){
        if (n<=1){
            return n;
        }
        else {
            return decrf(n-1)+decrf(n-2);
        }
    }*/
}
