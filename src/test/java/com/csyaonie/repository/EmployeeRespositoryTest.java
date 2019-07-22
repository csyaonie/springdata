package com.csyaonie.repository;

import com.csyaonie.base.JpaBaseTest;
import com.csyaonie.bean.Employee;
import org.junit.Test;

/**
 * @author zyf
 * @date 2019/7/22
 * @description
 */
public class EmployeeRespositoryTest extends JpaBaseTest {

    @Test
    public void findByName() {
        EmployeeRepository employeeRespository=ctx.getBean(EmployeeRepository.class);
        Employee employee=employeeRespository.findByName("zhangsan");
        System.out.println(employee.getName());
    }
}