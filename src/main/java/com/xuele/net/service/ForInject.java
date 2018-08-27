package com.xuele.net.service;
import com.xuele.net.aop.MyAnnotationTest;
import com.xuele.net.constants.MyProperties;
import org.springframework.stereotype.Service;

/**
 * Created by GaoQingming on 2017/8/15 0015.
 */
@Service
public class ForInject extends MyProperties {
    @MyAnnotationTest
    public int getMax() {
        return 11;
    }
}
