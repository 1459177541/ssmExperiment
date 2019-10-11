package chapter2.service.impl;

import chapter2.dao.Dao;
import chapter2.service.Service;

import java.util.Optional;

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
        return Optional.ofNullable(dao.getAll())
                .map(Object::toString)
                .or(()-> Optional.ofNullable(dao.getMap()).map(Object::toString))
                .orElse(dao.get());
    }
}
