package chapter2.dao;

import java.util.List;
import java.util.Map;

public interface Dao {
    String get();
    List<String> getAll();
    Map<Integer, String> getMap();
}
