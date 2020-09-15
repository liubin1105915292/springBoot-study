package com.luki.test;

import com.luki.config.vo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
    @Autowired
    private Person person;
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    DataSource dataSource;

    @Test
    public void test1() {
        System.out.println(person);
    }

    @Test
    public void test2() throws SQLException {
//        jdbc.execute("insert into E_USER_BIND_TEMP (BAND_ID, USER_ID, EXTEND_TYPE, EXTEND_ID, EXTEND_TIME, STATUS, ATTENTION_TIME, BIZ_CHANNEL, USER_TYPE, NICKNAME)\n" +
//                "values ('11251', '208398', '13', 'oFMgYvy1MqKJreLBS2Sm07KXz190', to_date('13-07-2018 14:24:31', 'dd-mm-yyyy hh24:mi:ss'), '1', to_date('01-01-9999', 'dd-mm-yyyy'), '1', '1', null)");
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        connection.close();
        System.out.println(connection);
    }
}
