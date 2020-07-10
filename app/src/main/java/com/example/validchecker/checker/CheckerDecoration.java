package com.example.validchecker.checker;

import android.widget.TextView;

import com.example.validchecker.util.ObjectUtils;
import com.example.validchecker.util.StringUtils;

import androidx.annotation.CallSuper;

/**
 * Created by zhong on 2019/7/21.
 */
public class CheckerDecoration implements Checker {
    private Checker checker;
    protected String tip;

    public CheckerDecoration(Checker checker, String tip){
        this.checker = checker;
        this.tip = tip;
    }

    public void setChecker(Checker checker){
        this.checker = checker;
    }

    @CallSuper
    @Override
    public String check(TextView textView, String text) {
        if (ObjectUtils.nonNull(checker)){
            String tip = checker.check(textView,text);
            if ( isNotEmpty(tip) ) return tip;
        }

        return null;
    }

    protected boolean isEmpty(String tip){
        return StringUtils.isEmpty(tip);
    }

    protected boolean isNotEmpty(String tip){
        return !StringUtils.isEmpty(tip);
    }
}
