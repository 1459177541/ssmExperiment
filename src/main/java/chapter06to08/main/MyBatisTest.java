package chapter06to08.main;

import chapter06to08.mapper.CustomerMapper;
import chapter06to08.model.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MyBatisTest {

    private static SqlSessionFactory factory;

    @BeforeAll
    static void start() throws IOException {
        factory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("chapter06to08/mybatis-config.xml"));
    }

    @Test
    void add(){
        try(SqlSession sqlSession = factory.openSession()){
            System.out.println(sqlSession
                    .getMapper(CustomerMapper.class)
                    .save(new Customer()
                            .setId(1)
                            .setName("user1")
                            .setJobs("student")
                            .setPhone("12345678910")
                    ));
            sqlSession.commit();
        }
    }

    @Test
    void delete(){
        try(SqlSession sqlSession = factory.openSession()){
            System.out.println(sqlSession
                    .getMapper(CustomerMapper.class)
                    .delete(1));
            sqlSession.commit();
        }
    }

    @Test
    void update(){
        try(SqlSession sqlSession = factory.openSession()){
            System.out.println(sqlSession
                    .getMapper(CustomerMapper.class).update(
                    new Customer()
                            .setId(1)
                            .setName("user1")
                            .setJobs("programmer")
                            .setPhone("10987654321")
            ));
            sqlSession.commit();
        }
    }

    @Test
    void select(){
        try(SqlSession sqlSession = factory.openSession()){
            System.out.println(sqlSession
                    .getMapper(CustomerMapper.class)
                    .findOne(1));
            sqlSession.commit();
        }
    }

    @Test
    void selectAll(){
        try(SqlSession sqlSession = factory.openSession()){
            sqlSession
                    .getMapper(CustomerMapper.class)
                    .findAll()
                    .forEach(System.out::println);
            sqlSession.commit();
        }
    }

    @Test
    void selectByColumn(){
        try(SqlSession sqlSession = factory.openSession()){
            sqlSession
                    .getMapper(CustomerMapper.class)
                    .findByColumn("name", "user1")
                    .forEach(System.out::println);
            sqlSession.commit();
        }
    }

    @Test
    void selectByName(){
        try(SqlSession sqlSession = factory.openSession()){
            sqlSession.getMapper(CustomerMapper.class)
                    .findByName("user")
                    .forEach(System.out::println);
            sqlSession.commit();
        }
    }
}
