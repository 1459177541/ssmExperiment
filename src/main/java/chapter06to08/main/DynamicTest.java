package chapter06to08.main;

import chapter06to08.mapper.DynamicMapper;
import chapter06to08.model.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DynamicTest {

    private static SqlSessionFactory factory;

    @BeforeAll
    static void start() throws IOException {
        factory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("chapter06to08/mybatis-config.xml"));
    }

    @Test
    void findByNameAndJobs() {
        try(SqlSession sqlSession = factory.openSession()){
            sqlSession.getMapper(DynamicMapper.class)
                    .findByNameAndJobs(new Customer()
                            .setName("user1").setJobs("student"))
                    .forEach(System.out::println);
            sqlSession.commit();
        }
    }

    @Test
    void findByNameOrJobs() {
        try(SqlSession sqlSession = factory.openSession()){
            sqlSession.getMapper(DynamicMapper.class)
                    .findByNameOrJobs(new Customer()
                    .setName("user1").setJobs("student"))
                    .forEach(System.out::println);
            sqlSession.commit();
        }}

    @Test
    void findByNameAndJobs2() {
        try(SqlSession sqlSession = factory.openSession()){
            sqlSession.getMapper(DynamicMapper.class)
                    .findByNameAndJobs2(new Customer()
                            .setName("user1").setJobs("student"))
                    .forEach(System.out::println);
            sqlSession.commit();
        }}

    @Test
    void findByNameAndJobs3() {
        try(SqlSession sqlSession = factory.openSession()){
            sqlSession.getMapper(DynamicMapper.class)
                    .findByNameAndJobs3(new Customer()
                            .setName("user1").setJobs("student"))
                    .forEach(System.out::println);
            sqlSession.commit();
        }
    }

    @Test
    void findByIds(){
        try(SqlSession sqlSession = factory.openSession()){
            sqlSession.getMapper(DynamicMapper.class)
                    .findByIds(Stream.of(1, 2).collect(Collectors.toList()))
                    .forEach(System.out::println);
            sqlSession.commit();
        }
    }

    @Test
    void findByName(){
        try(SqlSession sqlSession = factory.openSession()){
            sqlSession.getMapper(DynamicMapper.class)
                    .findByName("user")
                    .forEach(System.out::println);
            sqlSession.commit();
        }
    }

    @Test
    void update() {
        try(SqlSession sqlSession = factory.openSession()){
            System.out.println(sqlSession.getMapper(DynamicMapper.class)
                    .update(new Customer()
                            .setId(1)
                            .setPhone("10987654321")));
            sqlSession.commit();
        }
    }
}