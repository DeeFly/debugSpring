package com.xuele.net.constants;

import com.xuele.net.service.ForInject;
import com.xuele.net.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by GaoQingming on 2017/8/21 0021.
 */
@Component
public class TestPostConstruct {

    @Value("${annotation.value.test}")
    private String valueTest;

    private String testString;

    private ForInject forInject;

    @Autowired
    @Lazy
    private UrlConstant urlConstant;
    private TempService tempService;

    public TestPostConstruct(ForInject forInject, String testString) {
        System.out.println("执行了xml指定的构造方法----------------------------------------------");
        this.testString = testString;
        this.forInject = forInject;
    }

    //推荐这种方式注入
    // 只有一个构造方法可以用Autowired修饰
    // 如果需要注入基本类型，需要用xml配置
    @Autowired
    public TestPostConstruct(ForInject forInject) {
        System.out.println("执行了Autowired注释的构造方法----------------------------------------------");
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

    @PostConstruct
    public void testPostConstruct() {
        System.out.println("post Construct annotation");
    }

    //即使在这里睡10秒下面的也照样会执行
    @PreDestroy
    public void destroy() {
        System.out.println("pre destroy annotation test");
        //try {
        //    Thread.sleep(10000L);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        System.out.println("destroy test");
    }

    @Required  //这个注解要求必须要依赖注入（配置文件中）指定需要注入的值。
    public void setTempService(TempService tempService) {
        this.tempService = tempService;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }
}
