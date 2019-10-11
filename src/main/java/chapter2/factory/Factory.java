package chapter2.factory;

import chapter2.dao.Dao;
import chapter2.dao.impl.DaoImpl;

public class Factory {
    public Dao getDao(){
        System.out.println("factory getDao invoke");
        return new DaoImpl();
    }
}
