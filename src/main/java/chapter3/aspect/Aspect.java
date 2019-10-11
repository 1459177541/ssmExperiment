package chapter3.aspect;

public class Aspect {

    public void checkPermissions(){
        System.out.println("模拟检查权限");
    }

    public void log(){
        System.out.println("模拟记录日记");
    }

    public void error(Exception e){
        System.out.println("出现问题："+e.getMessage());
        e.printStackTrace();
    }
}
