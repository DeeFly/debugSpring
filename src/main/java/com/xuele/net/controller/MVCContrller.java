package com.xuele.net.controller;

import com.xuele.net.constants.MyProperties;
import com.xuele.net.constants.TestPostConstruct;
import com.xuele.net.constants.UrlConstant;
import com.xuele.net.service.ForInject;
import com.xuele.net.service.TempService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by GaoQingming on 2017/8/15 0015.
 */
@Controller
@RequestMapping("controller")
public class MVCContrller {
    @Autowired
    private UrlConstant urlConstant;
    @Autowired
    private ForInject forInject;
    @Autowired
    private TempService tempService;
    @Autowired
    private TestPostConstruct testPostConstruct;
    private final Logger logger = LoggerFactory.getLogger(MVCContrller.class);

    @RequestMapping("testAop")
    @ResponseBody
    public String testAop() {
        String s = "loggerValue";
        System.out.println("forInject--------------------------------------------------------");
        System.out.println(forInject.getMax());
        System.out.println("tempService------------------------------------------------------");
        System.out.println(tempService.getNum());
        System.out.println("jdbcUrl----------------------------------------------------------");
        System.out.println("jdbcUrl:" + urlConstant.getJdbcUrl());
        System.out.println("testPostConstruct----------------------------------------------------------");
        System.out.println("testPostConstruct in controller : " + testPostConstruct.getTestString());
        System.out.println("valueTest----------------------------------------------------------");
        System.out.println("valueTest:" + urlConstant.getValueTest());
        logger.debug("logger test :{} after value" , s);
        logger.info("logger test :{} after value" , s);
        logger.warn("logger test :{} after value" , s);
        logger.error("logger test :{} after value" , s);
        testPostConstruct.method();
        //String[] properties = MyProperties.getProperty("gaofei.test.properties").split(",");
        //List<String> p = Arrays.asList(properties);
        //for (String ps : p) {
        //    System.out.println(ps);
        //}
        System.out.println("properties Test : " + MyProperties.getProperty("gaofei.test.properties"));
        return "index";
    }

    /**
     * http://localhost:8080/web/controller/testParam/1/suffix?param=123
     * @param pathV
     * @param param
     * @param request
     * @return
     */
    @RequestMapping("testParam/{pathV}/suffix")
    @ResponseBody
    public String testController(@PathVariable(value = "pathV") String pathV, @RequestParam("param") String param, HttpServletRequest request) {
        System.out.println("pathV:" + pathV);
        System.out.println("param:" + param);
        return "index";
    }

}
