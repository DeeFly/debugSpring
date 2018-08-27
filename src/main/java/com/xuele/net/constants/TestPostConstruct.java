package com.xuele.net.constants;

import com.xuele.net.service.ForInject;
import jdk.nashorn.internal.runtime.ScriptFunctionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by GaoQingming on 2017/8/21 0021.
 */
@Component
public class TestPostConstruct {
    private String testString;

    @Autowired
    private ForInject forInject;

    public TestPostConstruct(String value) {
        this.testString = value;
        System.out.println("指定构造方法创建实例");
    }

    @PostConstruct
    public void init() {
        this.testString = "postConstruct";
        System.out.println("postConstruct: and inject Service : " + forInject.getMax());
    }

    //即使在这里睡10秒下面的也照样会执行
    @PreDestroy
    public void destroy() {
        //try {
        //    Thread.sleep(10000L);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        System.out.println("destroy test");
    }


    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }
}
