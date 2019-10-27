package chapter01;

public class A {
    public BI b;

    public A setB(BI b) {
        this.b = b;
        return this;
    }

    public void say(){
        System.out.println(b.say());
    }
}
