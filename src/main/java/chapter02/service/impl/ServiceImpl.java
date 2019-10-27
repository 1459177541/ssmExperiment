package chapter02.service.impl;

import chapter02.dao.Dao;
import chapter02.service.Service;

import java.util.List;
import java.util.Map;

public class ServiceImpl implements Service {

    private Dao dao;

    public ServiceImpl(){
        System.out.println("no-arg constructor invoke");
    }

    public ServiceImpl(Dao dao){
        System.out.println("arg constructor invoke");
        this.dao = dao;
    }

    public ServiceImpl setDao(Dao dao) {
        System.out.println("setDao invoke");
        this.dao = dao;
        return this;
    }

    @Override
    public String say() {
        List<String> list = dao.getAll();
        if (list != null) {
            return list.toString();
        }
        Map<Integer, String> map = dao.getMap();
        if (map != null) {
            return map.toString();
        }
        return dao.get();
    }
}
