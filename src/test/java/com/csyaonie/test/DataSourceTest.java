package com.csyaonie.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.applet.AppletContext;

/**
 * @author zyf
 * @date 2019/7/22
 * @description
 */
public class DataSourceTest {
    private ApplicationContext ctx=null;

    @Before
    public void setup(){
        ctx= new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("启动");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("关闭");
    }

    @Test
    public void testDataSource(){
        DataSource dataSource=(DataSource) ctx.getBean("dataSource");
        Assert.notNull(dataSource);
    }

    @Test
    public void testJDBCTemplate(){
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.notNull(jdbcTemplate);
    }
}
