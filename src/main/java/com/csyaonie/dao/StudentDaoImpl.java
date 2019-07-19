package com.csyaonie.dao;

import com.csyaonie.bean.Student;
import com.csyaonie.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyf
 * @date 2019/7/19
 * @description
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> query() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Student> students=new ArrayList<>();
        String sql="select id,name,age from student";
        try {
            connection= JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id =resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                Student student=new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
        return students;
    }

    @Override
    public void save(Student student) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="insert into student(name,age) values (?,?)";
        try {
            connection= JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
    }
}
