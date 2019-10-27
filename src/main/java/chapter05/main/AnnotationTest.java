package chapter05.main;

import chapter05.dao.AccountDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class AnnotationTest{

    private static AccountDao accountDao;

    @BeforeAll
    static void start(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("chapter05");
        accountDao = applicationContext.getBean(AccountDao.class);
    }

    @Test
    void noErrorTransfer(){
        accountDao.transfer(1, 2, 10.5, false);
    }

    @Test
    void hasErrorTransfer(){
        Assertions.assertThrows(ArithmeticException.class,
                ()->accountDao.transfer(1, 2, 10.5, true));
    }

    @Bean
    public DataSource dataSource(){
        return new DriverManagerDataSource("jdbc:mysql://localhost/test", "yxc", "816357492");
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
