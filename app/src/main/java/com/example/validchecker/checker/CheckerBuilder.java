package com.example.validchecker.checker;

/**
 * Created by zhong on 2020/7/6.
 */
public class CheckerBuilder {
    private Checker checker;

    public CheckerBuilder empty(String tip){
        checker = new EmptyChecker(checker,tip);
        return this;
    }

    public CheckerBuilder min(int min, String tip){
        checker = new MinChecker(checker,min,tip);
        return this;
    }

    public CheckerBuilder max(int max, String tip){
        checker = new MaxChecker(checker,max,tip);
        return this;
    }

    public CheckerBuilder phone( String tip){
        checker = new PhoneChecker(checker,tip);
        return this;
    }

    public Checker build(){
        return checker;
    }
}
