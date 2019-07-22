package com.csyaonie.dao;

import com.csyaonie.bean.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zyf
 * @date 2019/7/19
 * @description
 */
public class StudentDaoImplTest {

    @Test
    public void query() {
        StudentDao studentDao=new StudentDaoImpl();
        List<Student> students= studentDao.query();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void save() {
        Student student=new Student();
        student.setAge(11);
        student.setName("xiaoming");
        StudentDao studentDao=new StudentDaoImpl();
        studentDao.save(student);
    }
}