package com.example.validchecker.checker;

import android.app.Activity;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.validchecker.util.LogUtils;
import com.example.validchecker.util.StringUtils;
import com.example.validchecker.util.ToastUtils;

/**
 * Created by zhong on 2019/7/21.
 */
public class ValidChecker {
    private SparseArray<Checker> checkers = new SparseArray<>();
    private SparseIntArray indexArray = new SparseIntArray();

    public static ValidChecker getInstance(){
        return new ValidChecker();
    }

    public void clear(){
        checkers.clear();
        indexArray.clear();
    }

    /**
     * 添加提示
     * @param id EditView id
     * @param checker 检测接口
     */
    public ValidChecker addChecker(int id, Checker checker){
        Checker chainChecker = checkers.get(id);
        if (chainChecker != null) {
            ((CheckerDecoration)checker).setChecker(chainChecker);
        }
        checkers.put(id,checker);
        indexArray.put(indexArray.size(),id);
        return this;
    }

    public boolean check(Activity activity){
        ViewGroup contentView = activity.findViewById(android.R.id.content);
        return check(contentView);
    }

    /**
     * 检测EditView 值的有效性
     * @param viewGroup
     * @return 检测通过返回true,不通过返回false
     */
    public boolean check(ViewGroup viewGroup){
        //没有父布局的直接通过
        if (viewGroup == null) return true;

        //没有Checker直接通过
        if (checkers.size() <= 0) return true;

        final int count = indexArray.size();//checkers.size();
        int id;
        for (int i = 0; i < count; i++) {
            id = indexArray.get(i);//checkers.keyAt(i);
            View view = viewGroup.findViewById(id);
            //检测view是否是TextText及它的子类
            if (view instanceof TextView){
                String tip = checkTextView((TextView)view);
                if (!StringUtils.isEmpty(tip)) {
                    ToastUtils.show(tip);
                    return false;
                }
            }
            else {//不是TextView，输出错误日志进行提示
                String idName = view.getContext().getResources().getResourceEntryName(id);
                String vName = view.toString();
                String sName = vName.substring(0,vName.indexOf("{"));
                LogUtils.e("传入的R.id." + idName + "：" + sName + "，不是TextView及它的子类");
            }
        }

        clear();

        return true;
    }

    private String checkTextView(TextView textView){
        int id = textView.getId();
        return checkers.get(id).check(textView,textView.getText().toString());
    }
}
