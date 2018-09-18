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
        logger.info("forInject get min--------------------------------------------------------");
        logger.info("forInject get min:{}", forInject.getMin(1));
        logger.info("forInject get max--------------------------------------------------------");
        logger.info("forInject get max:{}", forInject.getMax());
        logger.info("forInject not aop--------------------------------------------------------");
        logger.info("forInject not aop:{}", forInject.notAop());
        logger.info("tempService get num------------------------------------------------------");
        logger.info("tempService get Num:{}", tempService.getNum());
        logger.info("jdbcUrl----------------------------------------------------------");
        logger.info("jdbcUrl:" + urlConstant.getJdbcUrl());
        logger.info("testPostConstruct----------------------------------------------------------");
        logger.info("testPostConstruct in controller : " + testPostConstruct.getTestString());
        logger.info("valueTest----------------------------------------------------------");
        logger.info("valueTest:" + urlConstant.getValueTest());
        logger.debug("logger test :{} after value" , s);
        logger.info("logger test :{} after value" , s);
        logger.warn("logger test :{} after value" , s);
        logger.error("logger test :{} after value" , s);
        testPostConstruct.method();
        //String[] properties = MyProperties.getProperty("gaofei.test.properties").split(",");
        //List<String> p = Arrays.asList(properties);
        //for (String ps : p) {
        //    logger.info(ps);
        //}
        logger.info("properties Test : " + MyProperties.getProperty("gaofei.test.properties"));
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
        logger.info("pathV:" + pathV);
        logger.info("param:" + param);
        return "index";
    }

}
