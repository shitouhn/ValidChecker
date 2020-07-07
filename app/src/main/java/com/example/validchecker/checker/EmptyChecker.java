package com.example.validchecker.checker;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by zhong on 2019/7/21.
 */
public class EmptyChecker extends CheckerDecoration {
    public EmptyChecker(String tip){
        this(null,tip);
    }

    public EmptyChecker(Checker checker, String tip) {
        super(checker, tip);
    }

    @Override
    public String check(TextView textView, String text) {
        if (isEmpty(text)) return tip;
        return super.check(textView, text);
    }
}
