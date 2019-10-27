package chapter02.dao.impl;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class AnnotationDaoImpl extends DaoImpl {
    public AnnotationDaoImpl(){
        System.out.println("AnnotationDaoImpl create");
    }
}
