package chapter02.factory;

import chapter02.dao.Dao;
import chapter02.dao.impl.DaoImpl;

public class StaticFactory {
    public static Dao getDao(){
        System.out.println("StaticFactory getDao invoke");
        return new DaoImpl();
    }
}
