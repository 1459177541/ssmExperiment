package chapter6.main;

import chapter6.model.Customer;
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
                .build(Resources.getResourceAsStream("chapter6/mybatis-config.xml"));
    }

    @Test
    void add(){
        try(SqlSession sqlSession = factory.openSession()){
            System.out.println(sqlSession.insert(
                    "customerMapper.save",
                    new Customer()
                            .setId(1)
                            .setName("user1")
                            .setJobs("student")
                            .setPhone("12345678910"))
            );
            sqlSession.commit();
        }
    }

    @Test
    void delete(){
        try(SqlSession sqlSession = factory.openSession()){
            System.out.println(sqlSession.delete(
                    "customerMapper.delete",
                    1
            ));
            sqlSession.commit();
        }
    }

    @Test
    void update(){
        try(SqlSession sqlSession = factory.openSession()){
            System.out.println(sqlSession.update(
                    "customerMapper.update",
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
            sqlSession.selectList(
                    "customerMapper.findOne",
                    1
            ).forEach(System.out::println);
            sqlSession.commit();
        }
    }

    @Test
    void selectAll(){
        try(SqlSession sqlSession = factory.openSession()){
            sqlSession.selectList("customerMapper.findAll").forEach(System.out::println);
            sqlSession.commit();
        }
    }
}
