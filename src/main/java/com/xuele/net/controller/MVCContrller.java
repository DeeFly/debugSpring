package com.xuele.net.controller;

import com.xuele.net.constants.MyProperties;
import com.xuele.net.constants.TestPostConstruct;
import com.xuele.net.constants.UrlConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by GaoQingming on 2017/8/15 0015.
 */
@Controller
@RequestMapping("controller")
public class MVCContrller {
    @Autowired
    private UrlConstant urlConstant;
    @Autowired
    private TestPostConstruct testPostConstruct;
    private final Logger logger = LoggerFactory.getLogger(MVCContrller.class);

    @RequestMapping("third")
    @ResponseBody
    public String testContrller() {
        String s = "loggerValue";
        System.out.println("third");
        System.out.println("jdbcUrl:" + urlConstant.getJdbcUrl());
        System.out.println("testPostConstruct in controller : " + testPostConstruct.getTestString());
        System.out.println("valueTest:" + urlConstant.getValueTest());
        logger.debug("logger test :{} after value" , s);
        logger.info("logger test :{} after value" , s);
        logger.warn("logger test :{} after value" , s);
        logger.error("logger test :{} after value" , s);

        //String[] properties = MyProperties.getProperty("gaofei.test.properties").split(",");
        //List<String> p = Arrays.asList(properties);
        //for (String ps : p) {
        //    System.out.println(ps);
        //}
        System.out.println("properties Test : " + MyProperties.getProperty("gaofei.test.properties"));
        return "index";
    }

}
