package com.example.validchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.validchecker.checker.CheckerBuilder;
import com.example.validchecker.checker.ValidChecker;
import com.example.validchecker.databinding.ActivityMainBinding;
import com.example.validchecker.util.ToastUtils;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding viewBinding;
    CheckerBuilder checkerBuilder = new CheckerBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        viewBinding.button.setOnClickListener(this::onClickButton);
    }

    public void onClickButton(View view){
        if (checkValid()) ToastUtils.show("提交中....");
    }

    private boolean checkValid(){
        return ValidChecker.getInstance()
                .addChecker(R.id.user_name,
                        new CheckerBuilder()
                                .empty("请输入用户名")
                                .min(4,"用户名至少需要4位")
                                .max(12,"用户名最大只能12位")
                                .build())
                .addChecker(R.id.password,
                        new CheckerBuilder()
                                .empty("请输入密码")
                                .min(4,"密码至少需要4位")
                                .max(18,"密码最大只能18位")
                                .build())
                .addChecker(R.id.phone,
                        new CheckerBuilder()
                                .empty("请输入手机号")
                                .phone("请输入正确的手机号")
                                .build())
                .check(this);
    }
}