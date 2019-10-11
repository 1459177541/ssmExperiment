package chapter2.dao.impl;

import chapter2.dao.Dao;

import java.util.List;
import java.util.Map;

public class DaoImpl implements Dao {

    private List<String> dataList;

    private Map<Integer, String> dataMap;

    public DaoImpl setDataList(List<String> dataList) {
        System.out.println("dao setDataList invoke");
        this.dataList = dataList;
        return this;
    }

    public DaoImpl setDataMap(Map<Integer, String> dataMap) {
        System.out.println("dao setDataMap invoke");
        this.dataMap = dataMap;
        return this;
    }

    @Override
    public String get() {
        return "Something...";
    }

    @Override
    public List<String> getAll() {
        return dataList;
    }

    @Override
    public Map<Integer, String> getMap() {
        return dataMap;
    }
}
