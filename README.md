# ValidChecker
在使用前检查EditView和TextView值是否有效。
用法如下：
addChecker()添加Id及检测器。
check()方法进行检测，返回true表示检测通过。

ValidChecker.getInstance()
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
