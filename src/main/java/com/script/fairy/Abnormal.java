package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    int x=0;

    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    int count_1 = 0;
    long i = 0;
    String task_id = AtFairyConfig.getOption("task_id");

    //全局处理
    public void erro() throws Exception {

        result = mFairy.findPic(433,116,814,308,"gxhd.png");
        mFairy.onTap(0.8f, result, 314,519,319,527, "恭喜获得", Sleep);

        result = mFairy.findPic(433,116,814,308,"gxhd.png");
        mFairy.onTap(0.8f, result, 314,519,319,527, "恭喜获得", Sleep);


        result = mFairy.findPic(19,592,119,714,"slts.png");
        if (result.sim>0.8f){
            result = mFairy.findPic(183,647,262,712,"yhxy.png");
            mFairy.onTap(0.8f, result, "err用户协议", Sleep);
            if (result.sim<0.8f) {
                result = mFairy.findPic(941, 529, 1230, 662, "jrjh.png");
                mFairy.onTap(0.8f, result, "err进入江湖", Sleep);

                result = mFairy.findPic(999,554,1272,669, "jryx.png");
                mFairy.onTap(0.8f, result, "err进入游戏", Sleep);
            }
        }

        result = mFairy.findPic(867,446,1050,531, "lq.png");
        mFairy.onTap(0.8f, result, "err领取", Sleep);

        result =mFairy.findPic(40,468,401,702,new String[]{"tcsq.png","jstg.png"});
        mFairy.onTap(0.8f, result, "退出省电模式", 500);

        result = mFairy.findPic(814,451,930,560, "khb.png");
        mFairy.onTap(0.8f, result, "err开红包", Sleep);

        result = mFairy.findPic(1006,259,1097,357, "hb.png");
        mFairy.onTap(0.8f, result, "err红包", Sleep);

        result = mFairy.findPic(766,174,959,281, "hbgb.png");
        mFairy.onTap(0.8f, result, 994,196,1002,202,"err红包关闭", Sleep);


    }

}
