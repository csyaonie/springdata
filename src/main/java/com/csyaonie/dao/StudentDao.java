package com.csyaonie.dao;

import com.csyaonie.bean.Student;

import java.util.List;

/**
 * @author zyf
 * @date 2019/7/19
 * @description
 */
public interface StudentDao {

    public List<Student> query();

    public void save(Student student);

}
