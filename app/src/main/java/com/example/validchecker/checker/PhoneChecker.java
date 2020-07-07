package com.example.validchecker.checker;

import android.widget.TextView;

import com.example.validchecker.util.PhoneUtil;

/**
 * Created by zhong on 2019/7/21.
 */
public class PhoneChecker extends CheckerDecoration {

    public PhoneChecker(Checker checker, String tip) {
        super(checker, tip);
    }

    @Override
    public String check(TextView textView, String text) {
        String t = super.check(textView, text);
        if (isNotEmpty(t)) return t;
        if ( !PhoneUtil.isPhone(text) ) return tip;
        return null;
    }
}
