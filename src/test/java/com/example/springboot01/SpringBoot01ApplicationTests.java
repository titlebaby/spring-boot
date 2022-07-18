package com.example.springboot01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBoot01ApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
        /**
         * @ConditionalOnBean // 当给定的在bean存在时,则实例化当前Bean
         * @ConditionalOnMissingBean // 当给定的在bean不存在时,则实例化当前Bean
         * @ConditionalOnClass // 当给定的类名在类路径上存在，则实例化当前Bean
         * @ConditionalOnMissingClass // 当给定的类名在类路径上不存在，则实例化当前Bean
         */
    }

}
