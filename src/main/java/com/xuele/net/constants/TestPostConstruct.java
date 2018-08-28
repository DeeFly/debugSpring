package com.xuele.net.constants;

import com.xuele.net.service.ForInject;
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

    private ForInject forInject;
    private UrlConstant urlConstant;

    public TestPostConstruct(ForInject forInject, String testString) {
        System.out.println("执行了xml指定的构造方法----------------------------------------------");
        this.testString = testString;
        this.forInject = forInject;
    }

    //推荐这种方式注入
    // 只有一个构造方法可以用Autowired修饰
    // 如果需要注入基本类型，需要用xml配置
    @Autowired
    public TestPostConstruct(ForInject forInject, UrlConstant urlConstant) {
        System.out.println("执行了Autowired注释的构造方法----------------------------------------------");
        this.urlConstant = urlConstant;
        this.forInject = forInject;
    }

    public void method() {
        System.out.println(forInject.getMax());
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
