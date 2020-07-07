package com.example.validchecker.checker;

import android.widget.TextView;


/**
 * Created by zhong on 2019/7/21.
 */
public class MinChecker extends CheckerDecoration {
    private int min = -1;

    public MinChecker(Checker checker, int min, String tip) {
        super(checker, tip);
        this.min = min;
    }

    @Override
    public String check(TextView textView, String text) {
        String t = super.check(textView,text);
        if (isNotEmpty(t)) return t;
        if (text.length() < min) return tip;
        return null;
    }
}
