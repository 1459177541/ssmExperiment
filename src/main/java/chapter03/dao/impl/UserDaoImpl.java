package chapter03.dao.impl;

import chapter03.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("add user");
    }

    @Override
    public void deleteruser() {
        System.out.println("deleter user");
    }
}
