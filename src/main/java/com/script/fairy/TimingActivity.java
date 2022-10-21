package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity extends TaskContent {
    AtFairyImpl mFairy;
    LimitlessTask limitlessTask;
    FindResult result;
    FindResult result1;
    FindResult result2;
    GameUtil gameUtil;
    boolean hjsl=true,hjsl1=true,ywsl=true,fldc=true,zhujiu=true,zld=true,bhkh=true,sjsl=true,sjzc=true,mpjj=true,wlls=true,zjjy=true,gcz=true,xflj=true,elrq=true,ydbz=true,jzwz=true,ljp=true,ljp1=true;
    ControlSplit back =null, begin =null;
    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
    }

    public int timingActivity() throws Exception {
        int h = mFairy.dateHour();
        int m = mFairy.dateMinute();
        int w = mFairy.week();
        int s=(h*60+m)*60;
        int sm = s*1000;
        int back=0;
        for (int i=0 ;i<=1;i++) {
            LtLog.e("查看限时任务！！！！！");

            if (!AtFairyConfig.getOption("optime6").equals("")) {
                begin = strSplit(AtFairyConfig.getOption("optime6"));
                LtLog.e("============" + begin.timeMillis);
            }

            //风陵渡船 fldc
            if (AtFairyConfig.getOption("fldc").equals("1") && fldc && ((h==11 && m<20) || (h==13 && m<20) ||(h==17 && m<20) ||(h==20 && m<20) ||(h==23 && m<50 && m>30))) {
                gameUtil.retire();
                gameUtil.goCity(50);
                fldc();
                fldc = false;
                back = 1;
            }

            //黄金首领
            if (AtFairyConfig.getOption("hjsl").equals("1") && hjsl && ( h==16 && m>=30)) {
                gameUtil.retire();
                gameUtil.goCity(50);
                hjsl();

                hjsl = false;
                back = 1;
            }

            //帮会烤火
            if (AtFairyConfig.getOption("bhkh").equals("1") && bhkh && (h==19 && ( m>=15 && m<25))) {
                gameUtil.retire();
                gameUtil.goCity(50);
                bhkh();
                bhkh = false;
                back = 1;
            }

            //黄金首领
            if (AtFairyConfig.getOption("hjsl").equals("1") && hjsl1 && (w!=4 && w!=7 && h==22 && m<30)) {
                gameUtil.retire();
                gameUtil.goCity(50);
                hjsl();
                hjsl1 = false;
                back = 1;
            }

            //世界首领
            if (AtFairyConfig.getOption("sjsl").equals("1") && sjsl && (h==12 || h==19) && m>=30 && m<=42) {
                gameUtil.retire();
                gameUtil.goCity(50);
                sjsl();
                sjsl = false;
                back = 1;
            }

            //宋金战场
            if (AtFairyConfig.getOption("sjzc").equals("1") && sjzc && (h==11 && m>=50 || h==12 && m<15) || (h==20 && m>=30 && m<55) || (h==22 && m>=30 && m<55)) {
                gameUtil.retire();
                gameUtil.goCity(50);
                sjzc();
                sjzc = false;
                back = 1;
            }
            //战龙洞 zld
            if (AtFairyConfig.getOption("zld").equals("1") && zld && ((w==1 || w==5) && h==20 && (m>0 && m<25))) {
                gameUtil.retire();
                gameUtil.goCity(50);
                zld();
                zld = false;
                back = 1;
            }
            //煮酒 zhujiu
            if (AtFairyConfig.getOption("zhujiu").equals("1") && zhujiu && ((w==1 || w==5) && h==21 && (m>0 && m<30))) {
                gameUtil.retire();
                gameUtil.goCity(50);
                zhujiu();
                zhujiu = false;
                back = 1;
            }

            if (AtFairyConfig.getOption("gxrc").equals("1")  && h==5  && m==1){
                hjsl=true;ywsl=true;fldc=true;bhkh=true;sjsl=true;hjsl1=true;
                sjzc=true;mpjj=true;wlls=true;zjjy=true;gcz=true;
                xflj=true;elrq=true;ydbz=true;zhujiu=true;zld=true;
                LtLog.e("5点重置任务" );
                limitlessTask.create();
                setTaskName(0);
            }

            //	剑指王者
            if (AtFairyConfig.getOption("5219").equals("1") && jzwz && s > 36000 && s < 85800) {

                boolean j = false;//判断是否开始剑指王者活动

                if (AtFairyConfig.getOption("jjc").equals("2")) {
                    LtLog.e(mFairy.getLineInfo("用户勾选无限打 - 开始活动"));
                    j = true;
                }

                if (AtFairyConfig.getOption("jjc").equals("1") || AtFairyConfig.getOption("DIYsj").equals("1")) {//是否勾选 diy 或者 首胜
                    if (!AtFairyConfig.getOption("start_time").equals("") && !AtFairyConfig.getOption("stop_time").equals("")) {//是否设置了时间
                        TaskContent.ControlSplit start_time = strSplit(AtFairyConfig.getOption("start_time"));//开始时间
                        TaskContent.ControlSplit stop_time = strSplit(AtFairyConfig.getOption("stop_time"));//结束时间

                        if ((h > start_time.h && h < stop_time.h) || (h == start_time.h && m >= start_time.m) || (h == stop_time.h && m < stop_time.m)) {
                            j = true;
                        }
                    } else {
                        LtLog.e(mFairy.getLineInfo("玩家没有设置时间！！！"));
                    }
                }
                if (j) {

                    jzwz();
                    jzwz = false;
                    back = 1;
                }
            }
            //领金票
            if (AtFairyConfig.getOption("ljp").equals("1") && ljp && s > 45000 && s < 50400) {
                gameUtil.cifu();
                ljp = false;
                back = 1;
            }
            //领金票
            if (AtFairyConfig.getOption("ljp").equals("1") && ljp1 && s > 66600 && s < 72000) {
                gameUtil.cifu();
                ljp1 = false;
                back = 1;
            }

           /* //领金票
            if (AtFairyConfig.getOption("ljp").equals("1") && ljp && s > 45000 && s < 50400) {
                gameUtil.tansuo();
                ljp = false;
                back = 1;
            }*/

        }
        return back;

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

    public void jzwz() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("hu1.png");
                mFairy.onTap(0.8f,result,986,122,1002,134,"关闭图腾界面",1000);
                int s1 =0;
                int s2 =0;
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s=(h*60+m)*60;

                if (!(s>36000 && s<85800)){        //(（当前时间大于10点小于24点）取反
                    LtLog.e(mFairy.getLineInfo("活动时间未到剑指王者结束"));
                    setTaskEnd();return;
                }/*else if (AtFairyConfig.getOption("DIYsj").equals("1") || AtFairyConfig.getOption("jjc").equals("1")) {
                    if (!AtFairyConfig.getOption("start_time").equals("")){

                        if (strSplit(AtFairyConfig.getOption("start_time")) != null) {
                            start = strSplit(AtFairyConfig.getOption("start_time"));//开始时间
                            s1 = (start.h * 60 + start.m) * 60;

                            stop = strSplit(AtFairyConfig.getOption("stop_time"));//结束时间
                            s2 = (stop.h * 60 + stop.m) * 60;

                            if (!(s >= s1 && s < s2)) {
                                LtLog.e(mFairy.getLineInfo("不在开始和结束时间以内剑指王者结束"));
                                setTaskEnd();
                                return;
                            }
                        }
                }
                }*/

                if(AtFairyConfig.getOption("jjc").equals("1") || AtFairyConfig.getOption("DIYsj").equals("1")){//是否勾选 diy 或者首胜
                    if(!AtFairyConfig.getOption("start_time").equals("") && !AtFairyConfig.getOption("stop_time").equals("")){//是否设置了时间
                        TaskContent.ControlSplit stop_time = strSplit(AtFairyConfig.getOption("stop_time"));//结束时间

                        if( (h>stop_time.h) || (h==stop_time.h && m>stop_time.m)) {
                            LtLog.e(mFairy.getLineInfo("已经达到设置的时间,结束任务!"));
                            setTaskEnd();
                            return;
                        }
                    }else{
                        LtLog.e(mFairy.getLineInfo("玩家没有设置时间！！！"));
                    }
                }

                /*if (back != null  && timekeep(0, back.timeMillis, "剑指王者打多久")) {
                    LtLog.e(mFairy.getLineInfo("时间到了剑指王者结束"));
                   *//* result =mFairy.findPic("chakanshuju.png");
                    mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);

                    result =mFairy.findPic(1003,484,1175,540,"tuichuzhanchang.png");
                    mFairy.onTap(0.8f,result,"退出战场",Sleep);
                    if (result.sim > 0.8f){

                    }*//*
                    setTaskEnd();return;
                }else {
                   *//* result =mFairy.findPic("chakanshuju.png");
                    mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);

                    result =mFairy.findPic(1003,484,1175,540,"tuichuzhanchang.png");
                    mFairy.onTap(0.8f,result,"退出战场",Sleep);*//*
                }*/

            }

            @Override
            public void create() throws Exception {
               /* if (AtFairyConfig.getOption("rbt").equals("1")) {
                    back = strSplit(AtFairyConfig.getOption("jzsj"));
                }*/
            }
            int ydcount=0;
            int x=179,y=479,x1=173,y1=662,a=0;
            boolean jjtime=true;
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                if (a==10){
                    a=0;
                    setTaskEnd();return;
                }

              //  if(overtime(30,99))return;
                int ret = gameUtil.mission("3v3Arena.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    gameUtil.close(1);
                    setTaskName(3);
                    return;
                }

              /*  result =mFairy.findPic("jiahao.png");
                mFairy.onTap(0.8f,result,"展开",Sleep);

                result =mFairy.findPic(281,2,1109,231,"jianzhi.png");
                mFairy.onTap(0.8f,result,"剑指王者",Sleep);

                result =mFairy.findPic("jianzhi2.png");
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }*/
            }

            public void content_2() throws Exception {
                if (overtime(30,0))return;

                result=mFairy.findPic(673,124,772,221,"3v3 dont match.png");
                mFairy.onTap(0.8f,result,"战场逃出，无法报名,等待5分钟",1000);
                //mFairy.onTap(0.8f,result,1241,60,1257,78,"关闭",1000);
                if(result.sim>0.8f){
                    mFairy.sleep(300000);
//                    setTaskEnd();
//                    return;
                }


                result =mFairy.findPic("zhanpao.png");
                mFairy.onTap(0.8f,result,641,437,650,443,"战袍模式",Sleep);

                result =mFairy.findPic(611,234,1271,572,"new_jymatching.png");
                mFairy.onTap(0.8f,result,"个人匹配",Sleep);

                result =mFairy.findPic(349,253,913,518,"yjzdwz.png");
                if (result.sim >0.8f) {
                    result = mFairy.findPic(657, 392, 913, 503, "Intheteam.png");
                    mFairy.onTap(0.8f, result, "队伍中确定", Sleep);
                }

                result =mFairy.findPic("nobao.png");
                if (result.sim>0.8f) {
                    LtLog.e("当前时间段不能报名");
                    setTaskEnd();
                }
                result =mFairy.findPic("nobao.png");
                if (result.sim>0.8f) {
                    LtLog.e("当前时间段不能报名");
                    setTaskEnd();
                }



                result =mFairy.findPic(611,234,1271,572,"pipeizhong.png");
                if (result.sim>0.8f){
                    err=0;
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                }
                result =mFairy.findPic("jybattle.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);
                if (result.sim>0.8f) {
                    jjtime = true;
                }
                result =mFairy.findPic(584,4,700,99,"vs.png");
                if (result.sim>0.8f){
                    result =mFairy.findPic(419,58,488,105,"wofang.png");
                    result1 =mFairy.findPic(1119,4,1280,37,new String[]{"1d1jjc.png","jlpk.png"});
                    if (result.sim>0.8f){
                        if (result1.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("竞技场我方在左边 直走"));
                            x=174;
                            y=500;
                            x1=174;
                            y1=630;
                        }else {
                            LtLog.e(mFairy.getLineInfo("竞技场我方在左边"));
                            x = 253;
                            y = 556;
                            x1 = 89;
                            y1 = 572;
                        }
                    }
                    result =mFairy.findPic(778,65,845,99,"wofang.png");
                    result1 =mFairy.findPic(1119,4,1280,37,new String[]{"1d1jjc.png","jlpk.png"});
                    if (result.sim>0.8f){
                        if (result1.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("竞技场我方在左边 直走"));
                            x=174;
                            y=500;
                            x1=174;
                            y1=630;
                        }else {
                            LtLog.e(mFairy.getLineInfo("竞技场我方在右边"));
                            x = 90;
                            y = 593;
                            x1 = 257;
                            y1 = 576;
                        }
                    }
                }

                result1 =mFairy.findPic(509,0,803,128,"vs.png");
                result =mFairy.findPic(1118,2,1280,33,new String[]{"gp.png","jjc.png",});
                result2 =mFairy.findPic(593,69,694,103,"zdjd.png");
                if (result2.sim>0.8f){
                    if (jjtime){
                        Thread.sleep(12000);
                        jjtime=false;
                    }
                    err=0;
                    LtLog.e(mFairy.getLineInfo("竞技场中"));
                    mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                    mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                    mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                    result =mFairy.findPic(989,163,1048,348,new  String[]{"diren.png","diren1.png"});
                    result1=mFairy.findPic(393,115,455,139,"blood line.png");
                    if (result.sim>0.7f||result1.sim>0.8f){
                        ydcount=0;
                        LtLog.e(mFairy.getLineInfo("有敌人"));
                        mFairy.onTap(1172,610,1191,622,"普攻下",1);
                        mFairy.onTap(1118,483,1138,497,"技能1",1);
                        mFairy.onTap(1223,473,1242,489,"技能2",1);
                        mFairy.onTap(1039,552,1057,569,"技能3",1);
                        mFairy.onTap(1049,646,1065,663,"技能4",1);
                    }else {
                        LtLog.e(mFairy.getLineInfo("没有敌人，移动一下"));
                        ydcount++;
                        if (ydcount<15){

                            mFairy.ranSwipe(174,572,x,y,1500, (long) 100,1);
                        }else if (ydcount>=15 && ydcount<=18){
                            mFairy.ranSwipe(174,572,x1,y1,1500, (long) 100,1);
                        }
                        if (ydcount>18){
                            ydcount=0;
                        }
                    }
                }
                result =mFairy.findPic(839,5,1277,125,new String[]{"3v3leave.png","3v3leave1.png"});
                if (result.sim>0.8f){
                    jjtime=true;
                    LtLog.e(mFairy.getLineInfo("竞技结束"));
                    if (AtFairyConfig.getOption("jjc").equals("1")) {
                        result =mFairy.findPic(459,5,865,186,"3v3victory.png");
                        if (result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("胜利一次完成"));
                            result =mFairy.findPic("chakanshuju.png");
                            mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);

                            result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                            mFairy.onTap(0.8f,result,"退出战场",Sleep);
                            if (result.sim > 0.8f) {
                                setTaskEnd();
                                return;
                            }
                        }
                    }
                    result =mFairy.findPic("chakanshuju.png");
                    mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);

                    result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                    mFairy.onTap(0.8f,result,"退出战场",Sleep);
                }
            }

            public void content_3() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic(950,4,1120,156,"daily.png");
                mFairy.onTap(0.8f,result,1077,44,1081,56,"打开日常扩展栏",1000);

                result = mFairy.findPic(273,8,1118,248,"jianzhi3.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"剑指王者图标点击",1000);
                    setTaskName(2);
                    return;
                }else{
                   a++;
                }
                if (a>5){
                    a=10;
                    setTaskName(1);
                    return;
                }

            }
        }.taskContent(mFairy, "剑指王者中");
    } //剑指王者

    public void fldc() throws Exception{
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int w = mFairy.week();
                if ((h==11 && m<15) || (h==13 && m<15) ||(h==17 && m<20) ||(h==20 && m<20) ||(h==23 && m<50 && m>30)){
                }else{
                    LtLog.e(mFairy.getLineInfo("活动时间已过结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("fldc.png", 3);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic( 784,415,999,569, "jinru.png");
                mFairy.onTap(0.7f, result, "进入", 1500);

                result1 = mFairy.findPic( 796,164,970,427, "dc.png");
                if (result.sim>0.8f) {
                    mFairy.onTap(0.7f, result1, "选择渡船", 500);
                }else{
                    result = mFairy.findPic( 1091,641,1188,719, "shoudong1.png");
                    mFairy.onTap(0.7f, result, "开启自动", 1500);
                }

                result = mFairy.findPic( 485,174,797,273, "aqqn.png");
                if (result.sim>0.8f  && result1.sim>0.8f){
                    LtLog.e("查看活动！");
                    setTaskName(0);
                    return;
                }

                result1 = mFairy.findPic( 1118,3,1277,31, "chuan.png");
                if (result.sim>0.8f){
                    result = mFairy.findPic( 1091,641,1188,719, "shoudong1.png");
                    mFairy.onTap(0.7f, result, "开启自动", 1500);
                }

                result = mFairy.findPic( 417,627,843,717, "bjt.png");
                if (result.sim>0.8f){
                    LtLog.e("被击退 结束任务！");
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "风陵渡船");
    }//风陵渡船

    public void zld() throws Exception{
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int w = mFairy.week();
                if ((w==1 || w==5) && h==20 && (m>0 && m<25)){
                }else{
                    LtLog.e(mFairy.getLineInfo("活动时间已过结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("zld.png", 3);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic( 784,415,999,569, "jinru.png");
                mFairy.onTap(0.7f, result, "进入", 1500);

                result1 = mFairy.findPic( 796,164,970,427, "dc.png");
                if (result.sim>0.8f) {
                    mFairy.onTap(0.7f, result1, "选择渡船", 500);
                }else{
                    result = mFairy.findPic( 1091,641,1188,719, "shoudong1.png");
                    mFairy.onTap(0.7f, result, "开启自动", 1500);
                }

                result = mFairy.findPic( 485,174,797,273, "aqqn.png");
                if (result.sim>0.8f  && result1.sim>0.8f){
                    LtLog.e("查看活动！");
                    setTaskName(0);
                    return;
                }

                result1 = mFairy.findPic( 1118,3,1277,31, "chuan.png");
                if (result.sim>0.8f){
                    result = mFairy.findPic( 1091,641,1188,719, "shoudong1.png");
                    mFairy.onTap(0.7f, result, "开启自动", 1500);
                }

                result = mFairy.findPic( 417,627,843,717, "bjt.png");
                if (result.sim>0.8f){
                    LtLog.e("被击退 结束任务！");
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "风陵渡船");
    }//风陵渡船

    public void zhujiu() throws Exception{
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int w = mFairy.week();
                if ((w==1 || w==5) && h==21 && (m>0 && m<30)){
                }else{
                    LtLog.e(mFairy.getLineInfo("活动时间已过结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("zhujiu.png", 3);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(20, 0)) return;
                result = mFairy.findPic( 757,417,921,542, "jinru.png");
                mFairy.onTap(0.7f, result, "进入", 1500);


                result = mFairy.findPic( 1115,0,1276,29, new String[]{"zhujiu1.png","zhujiu2.png"});
                if (result.sim>0.8f  && result1.sim>0.8f){
                    LtLog.e("煮酒中！");
                    err=0;
                }
            }
        }.taskContent(mFairy, "煮酒");
    }//煮酒

    public void hjsl() throws Exception{
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int w = mFairy.week();
                if ((h==16 && m>=30) || (w!=4 && w!=7 && h==22 && m<30)){
                }else{
                    LtLog.e(mFairy.getLineInfo("活动时间已过结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                result1 = mFairy.findPic( 1120,3,1264,30, "sl2.png");
                if (result1.sim>0.8f){
                    setTaskName(2);
                    return;
                }
                int ret = gameUtil.mission("hjsl.png", 3);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            int x=1,x1=0;
            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                result = mFairy.findPic( 189,64,537,581, "heping.png");
                mFairy.onTap(0.7f, result, "和平地图", 500);

                result = mFairy.findPic( 896,557,1086,650, "qw1.png");
                mFairy.onTap(0.7f, result, "前往", 500);

                result = mFairy.findPic( 1091,641,1188,719, "shoudong1.png");
                mFairy.onTap(0.7f, result, "开启自动", 500);

                if (dazeTime>5){
                    result = mFairy.findPic( 412,130,877,262, "hjsl3.png");
                    if (result.sim<0.8f){
                        LtLog.e("附近没有首领");

                        result = mFairy.findPic( 154,25,411,100, "sl.png");
                        result1 = mFairy.findPic( 1120,3,1264,30, "sl2.png");
                        if (result.sim>0.8f||result1.sim>0.8f){

                            LtLog.e("首领地图中");
                            result = mFairy.findPic(3, 114, 131, 181, "fb.png");
                            mFairy.onTap(0.7f, result, 1186, 84, 1196, 95, "打开地图", 500);

                            result = mFairy.findPic( 990,497,1113,616, "hjsl2.png");
                            if (result.sim > 0.8f){
                                result = mFairy.findPic( 257,113,1084,651, "0"+x+++".png");
                                mFairy.onTap(0.7f, result, "位置", 500);
                                mFairy.onTap(0.7f, result, 1101,54,1114,68,"关闭地图", 500);
                                if (x>3){
                                    x=1;
                                }
                                x1=0;
                            }else{
                                x1++;
                                if (x1>3) {
                                    LtLog.e("地图中没有首领 结束任务");
                                    setTaskEnd();
                                    return;
                                }
                            }
                            mFairy.initMatTime();
                        }

                    }
                }



            }
        }.taskContent(mFairy, "黄金首领");
    }//黄金首领

/*    public void ywsl() throws Exception{
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("ywsl.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

            }
        }.taskContent(mFairy, "野外首领");
    }//野外首领*/

    public void bhkh() throws Exception{
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                if (h==19 && ( m>=15 && m<25)){
                }else{
                    LtLog.e(mFairy.getLineInfo("活动时间已过结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("bhkh.png", 3);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

                result = mFairy.findPic(703,208,1042,283, "zhankai.png");
                mFairy.onTap(0.8f, result, "展开", 500);

                result = mFairy.findPic( 321,148,960,566, "sfqw.png");
                mFairy.onTap(0.8f, result, 780,505,793,512,"前往", 500);

                if (AtFairyConfig.getOption("bhdt").equals("1")) {
                    result = mFairy.findPic(747,365,980,402, "dt.png");
                    mFairy.onTap(0.8f, result, 796,455,805,462,"点击答题", Sleep);

                    result = mFairy.findPic(270,125,428,202, "ti.png");
                    if (result.sim>0.8f){
                        result = mFairy.findPic(316,372,943,545, "yi.png");
                        mFairy.onTap(0.8f, result, "默认壹", 500);

                        result = mFairy.findPic(277,136,1025,572, "qrda.png");
                        mFairy.onTap(0.8f, result, 777,503,793,514,"确认答案", 10000);

                    }
                }

                result = mFairy.findPic(571,4,1278,524, new String[]{"cha1.png","cha2.png"});
                mFairy.onTap(0.8f, result, "关叉", 500);

            }
        }.taskContent(mFairy, "帮会烤火");
    }//帮会烤火

    public void sjsl() throws Exception{
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                result = mFairy.findPic( 420,254,826,396, "tzjs.png");
                if (result.sim >= 0.8f) {
                    mFairy.onTap(0.7f, result, 628,502,645,513,"挑战结束", 500);
                    setTaskEnd();return;
                }
                if ((h==12 || h==19) && m>=30 && m<=42){
                }else{
                    LtLog.e(mFairy.getLineInfo("活动时间已过结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("sjsl1.png", 3);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(15,0))return;

                result = mFairy.findPic( 671,443,941,582, "qw2.png");
                mFairy.onTap(0.8f, result, "前往", 1500);

                result = mFairy.findPic( 66,21,421,116, "sjsl2.png");
                if (result.sim >= 0.8f){
                    LtLog.e("世界选择首领中");
                    result = mFairy.findPic( 671,443,941,582, "qw2.png");
                    if (result.sim >= 0.8f) {
                        mFairy.onTap(0.8f, result, "前往", 1500);
                    }else{
                        result = mFairy.findPic(868, 551, 1131, 667, "tzbs.png");
                        mFairy.onTap(0.8f, result, "挑战boss", 1500);
                    }

                }

                result = mFairy.findPic( 1,119,274,356, "sjsl3.png");
                if (result.sim>=0.8f){
                    result = mFairy.findPic(1091,636,1184,718, new String[]{"sdzd.png", "sdzd1.png"});
                    mFairy.onTap(0.8f,result, "开启自动战斗", Sleep);
                }

                result = mFairy.findPic( 1093,2,1277,30, "trj.png");
                if (result.sim >= 0.8f) {
                   err=0;
                }




                result = mFairy.findPic( 831,599,1104,709, "lk.png");
                if (result.sim >= 0.8f) {
                    mFairy.onTap(0.7f, result, "结束", 500);
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy, "世界首领");
    }//世界首领

    public void sjzc() throws Exception{
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                if ((h==11 && m>=50 || h==12 && m<15) || (h==20 && m>=30 && m<55) || (h==22 && m>=30 && m<55)){
                }else{
                    LtLog.e(mFairy.getLineInfo("活动时间已过结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("sjzc.png", 3);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

                result = mFairy.findPic( 618,124,1033,575, "bmcj.png");
                mFairy.onTap(0.7f, result, "报名", 500);

                result = mFairy.findPic( 682,451,887,573, "qw1.png");
                mFairy.onTap(0.7f, result, "前往", 500);

                result = mFairy.findPic( 1,171,267,280, "xczc.png");
                mFairy.onTap(0.8f, result, "准备中", 5000);

                result = mFairy.findPic( 1121,2,1260,28, "zbz.png");
                mFairy.onTap(0.8f, result, "准备中", 5000);

                result = mFairy.findPic( 575,44,727,162, "dz.png");
                result1 = mFairy.findPic( 1137,4,1254,29, "zcz.png");
                if (result.sim>0.8f || result1.sim>0.8f){
                    setTaskName(3);
                    return;
                }

            }
            public void content_3() throws Exception {
                if (overtime(10, 2)) return;
                result = mFairy.findPic( 575,44,727,162, "dz.png");
                result1 = mFairy.findPic( 1137,4,1254,29, "zcz.png");
                if (result.sim>0.8f || result1.sim>0.8f){
                    result2 = mFairy.findPic(1091,636,1184,718, new String[]{"sdzd.png", "sdzd1.png"});
                    mFairy.onTap(0.8f,result2, "开启自动战斗", Sleep);
                    mFairy.onTap(1186,70,1197,83,"打开地图", 1000);
                    mFairy.onTap(634,373,637,382,"地图中间", 500);
                    mFairy.onTap(1107,55,1110,66,"关闭地图", 500);

                    setTaskName(4);
                    return;
                }
            }
            public void content_4() throws Exception {

                result2 = mFairy.findPic(1091,636,1184,718, new String[]{"sdzd.png", "sdzd1.png"});
                mFairy.onTap(0.8f,result2, "开启自动战斗", Sleep);

                result = mFairy.findPic( 575,44,727,162, "dz.png");
                result1 = mFairy.findPic( 1137,4,1254,29, "zcz.png");

                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 15){
                    if (result.sim>0.8f || result1.sim>0.8f){
                        mFairy.initMatTime();
                        mFairy.onTap(1186,70,1197,83,"打开地图", 1000);
                        mFairy.onTap(634,373,637,382,"地图中间", 500);
                        mFairy.onTap(1107,55,1110,66,"关闭地图", 500);
                        setTaskName(4);
                        return;
                    }
                }
                if (dazeTime > 100){
                    mFairy.initMatTime();
                    setTaskName(3);
                    return;
                }
                result = mFairy.findPic(983,572,1161,666, "lkzc1.png");
                if (result.sim>0.8f) {
                    mFairy.onTap(0.8f, result, "离开战场", Sleep);
                    LtLog.e("战场结束");
                    result = mFairy.findPic(983,572,1161,666, "lkzc1.png");
                    if (result.sim>0.8f) {
                        mFairy.onTap(0.8f, result, "离开战场", Sleep);
                    }else {
                        setTaskEnd();
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "宋金战场");
    }//宋金战场

    public void mpjj() throws Exception{
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("fldc.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

            }
        }.taskContent(mFairy, "门派竞技");
    }//门派竞技

    public void wlls() throws Exception{
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("fldc.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

            }
        }.taskContent(mFairy, "武林联赛");
    }//武林联赛

    public void zjjy() throws Exception{
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("fldc.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

            }
        }.taskContent(mFairy, "煮酒聚义");
    }//煮酒聚义

    public void gcz() throws Exception{
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("fldc.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

            }
        }.taskContent(mFairy, "攻城战");
    }//攻城战

    public void xflj() throws Exception{
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("fldc.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

            }
        }.taskContent(mFairy, "侠峰论剑");
    }//侠峰论剑

    public void elrq() throws Exception{
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("fldc.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

            }
        }.taskContent(mFairy, "恶狼入侵");
    }//恶狼入侵

    public void ydbz() throws Exception{
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                int ret = gameUtil.mission("fldc.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

            }
        }.taskContent(mFairy, "炎帝宝藏");
    }//炎帝宝藏

}
