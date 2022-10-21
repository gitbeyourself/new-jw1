package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;


/**
 * Created by Administrator on 2019/1/24 0024.
 */

public class TaskMain {
     AtFairyImpl mFairy;
     GameUtil gameUtil;
     TeamTask teamTask;
     SingleTask singleTask;
     LimitlessTask limitlessTask;
     TimingActivity timingActivity;
     OtherGame otherGame;
     static List<String> list = new ArrayList<>();
     public  TaskMain (AtFairyImpl ypFairy) throws Exception {
         mFairy = ypFairy;
         mFairy.setGameName("剑网1：归来任务");
         mFairy.setGameVersion(45);
         init();
         gameUtil = new GameUtil(mFairy);
         teamTask=new TeamTask(mFairy);
         singleTask=new SingleTask(mFairy);
         limitlessTask=new LimitlessTask(mFairy);
         timingActivity=new TimingActivity(mFairy);
         otherGame=new OtherGame(mFairy);
         mFairy.initMatTime();
         list.clear();
    }

     public void main() throws Exception {

         if(!AtFairyConfig.getOption("task_id").equals("")){
             task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
         }

         if (task_id!=2705&&task_id!=100&&task_id!=2161&&!AtFairyConfig.getOption("test").equals("1")){
             /*gameUtil.setUp1();*/
             gameUtil.setUp();
         }
         switch (task_id) {
             //单人日常
             case 2703:
                 LtLog.e("1937中");
                 if (AtFairyConfig.getOption("qdzh").equals("1")){//签到追回
                     gameUtil.fuli();//签到追回
                 }//签到追回
                 if (AtFairyConfig.getOption("wk").equals("1")||AtFairyConfig.getOption("gpzj").equals("1")){//gpzj 贡品征集
                     singleTask.gpzj();
                 }//贡品征集
                 if (AtFairyConfig.getOption("kj").equals("1")||AtFairyConfig.getOption("mrdt").equals("1")){//mrdt 每日答题
                     singleTask.keju2();//科举
                 }//mrdt 每日答题
                 if (AtFairyConfig.getOption("yinttt").equals("1")||AtFairyConfig.getOption("bhcg").equals("1")){//帮会传功
                     singleTask.bhcg();//通天塔
                 }//帮会传功
                 if (AtFairyConfig.getOption("yinjgly").equals("1")||AtFairyConfig.getOption("smrw").equals("1")){//smrw 师门任务
                     singleTask.smrw();
                 }//rmrw 师门任务
                 if (AtFairyConfig.getOption("xmrw").equals("1")||AtFairyConfig.getOption("lmbj").equals("1")){//lmbj 龙门镖局//未完善
                     singleTask.lmbj();//血盟任务
                 }//lmbj 龙门镖局
                 break;
             //组队
             case 2707:

                 if (AtFairyConfig.getOption("xtd").equals("1")) {
                     gameUtil.retire();
                 }

                 if (AtFairyConfig.getOption("sstj").equals("1")){
                     teamTask.aDragon("sstj.png",5);
                 }

                 break;
             //定点挂机
             case 2709:
                 timingActivity.timingActivity();

                 if (AtFairyConfig.getOption("qdzh").equals("1")){
                     gameUtil.fuli();//签到追回
                 }

                 limitlessTask.fieldHangMachine();
                 break;
             case 2705:
                 singleTask.novice();
                 break;
             case 2677:
                 if (mFairy.dateHour()>=10){
                     if (AtFairyConfig.getOption("gddxz").equals("1")){
                         otherGame.dxz1();
                     }else {
                         otherGame.dxz();
                     }
                 }
                 break;

         }
         mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
         Thread.sleep(2000);
         LtLog.e("sase后");
    }

    private int  task_id;
    public void  init() throws Exception {
        task_id=0;
        try {
            JSONObject   optionJson = new JSONObject(AtFairyConfig.getUserTaskConfig());
            LtLog.e(mFairy.getLineInfo("选项列表" + optionJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!AtFairyConfig.getOption("task_id").equals("")) {
            task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }
    }

}
