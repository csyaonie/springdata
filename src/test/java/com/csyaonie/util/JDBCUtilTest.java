package com.csyaonie.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author zyf
 * @date 2019/7/19
 * @description
 */
public class JDBCUtilTest {

    @Test
    public void getConnection() throws Exception {
        Connection connection=JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}