package com.csyaonie.dao;

import com.csyaonie.bean.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zyf
 * @date 2019/7/22
 * @description
 */
public class StudentDaoSpringJdbcImplTest {

    private ApplicationContext ctx=null;
    private StudentDao studentDao=null;

    @Before
    public void setup(){
        ctx= new ClassPathXmlApplicationContext("beans.xml");
        studentDao=(StudentDao) ctx.getBean("studentDao");
        System.out.println("启动");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("关闭");
    }

    @Test
    public void query() {
        List<Student> students= studentDao.query();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void save() {
        Student student=new Student();
        student.setAge(13);
        student.setName("xiaoming");
        studentDao.save(student);
    }
}