package com.csyaonie.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zyf
 * @date 2019/7/22
 * @description
 */
public class JpaDataSourceTest {
    private ApplicationContext ctx=null;

    @Before
    public void setup(){
        ctx= new ClassPathXmlApplicationContext("jpabeans.xml");
        System.out.println("启动");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("关闭");
    }

    @Test
    public void test(){

    }
}
