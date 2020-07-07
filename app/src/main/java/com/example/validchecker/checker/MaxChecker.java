package com.example.validchecker.checker;

import android.widget.TextView;

/**
 * Created by zhong on 2019/7/21.
 */
public class MaxChecker extends CheckerDecoration {
    private int max = Integer.MAX_VALUE;

    public MaxChecker(Checker checker, int max, String tip) {
        super(checker, tip);
        this.max = max;
    }

    public void setMax(int max){
        this.max = max;
    }

    @Override
    public String check(TextView textView, String text) {
        String t = super.check(textView, text);
        if (isNotEmpty(t)) return t;
        if (text.length() > max) return tip;
        return null;
    }
}
