package com.csyaonie.base;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zyf
 * @date 2019/7/22
 * @description
 */
public class JpaBaseTest {
    protected ApplicationContext ctx=null;

    @Before
    public void setup(){
        ctx= new ClassPathXmlApplicationContext("jpabeans.xml");
        System.out.println("jpa启动");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("jpa关闭");
    }

}
