package com.xuele.net.service;

import com.xuele.net.aop.MyAnnotationTest;
import com.xuele.net.constants.MyProperties;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GaoQingming on 2017/8/15 0015.
 */
@Service
public class ForInject extends MyProperties {
    //测试循环引用
    @Autowired
    private TempService tempService;

    @MyAnnotationTest
    public int getMax() {
        //测试在切面中调用自己类中的一个方法，该方法会不会走切面 如果不用这种方式，那确实不会走增强器。
        System.out.println("测试在切面中调用自己类中的一个方法，该方法会不会走切面:" + ((ForInject) AopContext.currentProxy()).getMin());
        return 11;
    }

    public int getMin() {
        return 0;
    }


    public void callTempService() {
        tempService.getForInject().getMax();
    }
}
