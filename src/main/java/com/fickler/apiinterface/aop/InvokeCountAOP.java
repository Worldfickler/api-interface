package com.fickler.apiinterface.aop;

import javax.annotation.Resource;

/**
 * 调用次数切面
 * @author dell
 * @date 2023/9/4 9:17
 */

public class InvokeCountAOP {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    // 定义切面触发的时机(什么时候执行)
    public void doInvokeCountAop() {
        // 调用方法
        object.proceed();
        // 调用成功之后，次数 +1
        userInterfaceInfoService.invokeCount();
    }

}
