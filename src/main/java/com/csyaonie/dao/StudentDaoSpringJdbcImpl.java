package com.csyaonie.dao;

import com.csyaonie.bean.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyf
 * @date 2019/7/22
 * @description
 */
public class StudentDaoSpringJdbcImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> query() {
        final List<Student> students=new ArrayList<>();
        String sql="select id,name,age from student";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id =resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                Student student=new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }
        });
        return students;
    }

    @Override
    public void save(Student student) {
        String sql="insert into student(name,age) values (?,?)";
        jdbcTemplate.update(sql,student.getName(),student.getAge());
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
