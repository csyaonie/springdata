package com.csyaonie.test;


import com.csyaonie.bean.Student;
import com.csyaonie.dao.StudentDao;
import com.csyaonie.dao.StudentDaoImpl;
import com.csyaonie.dao.StudentDaoSpringJdbcImpl;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author zyf
 * @date 2019/7/22
 * @description
 */
public class SpirngTest {

    @Test
    public void test(){
        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:mysql:///spring_data");
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123123");
        JdbcTemplate jdbcTemplate=new JdbcTemplate(driverManagerDataSource);
        StudentDaoSpringJdbcImpl studentDaoSpringJdbcImpl=new StudentDaoSpringJdbcImpl();
        studentDaoSpringJdbcImpl.setJdbcTemplate(jdbcTemplate);
        Student student=new Student();
        student.setAge(18);
        student.setName("xiaohong");
        studentDaoSpringJdbcImpl.save(student);
    }
}
