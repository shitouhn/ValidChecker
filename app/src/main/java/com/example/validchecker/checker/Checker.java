package com.example.validchecker.checker;

import android.widget.TextView;

/**
 * Created by zhong on 2019/7/21.
 */
public interface Checker {
    /**
     * 检测有效性
     * @param textView TextView 控件
     * @param text textView.getText()中的文本值
     * @return 返回检测结果，null or "" 表示检测通过,不为空表示检测不通过，返回的文本表示为要提示的内容
     */
    String check(TextView textView, String text);
}
