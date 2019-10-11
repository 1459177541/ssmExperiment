package chapter2.factory;

import chapter2.dao.Dao;
import chapter2.dao.impl.DaoImpl;

public class StaticFactory {
    public static Dao getDao(){
        System.out.println("StaticFactory getDao invoke");
        return new DaoImpl();
    }
}
