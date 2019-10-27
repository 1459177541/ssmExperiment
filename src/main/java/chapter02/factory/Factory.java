package chapter02.factory;

import chapter02.dao.Dao;
import chapter02.dao.impl.DaoImpl;

public class Factory {
    public Dao getDao(){
        System.out.println("factory getDao invoke");
        return new DaoImpl();
    }
}
