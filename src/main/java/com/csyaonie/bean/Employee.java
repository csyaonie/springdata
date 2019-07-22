package com.csyaonie.bean;

import javax.persistence.*;

/**
 * @author zyf
 * @date 2019/7/22
 * @description
 */
@Entity
public class Employee {
    private Integer id;
    private String name;
    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
