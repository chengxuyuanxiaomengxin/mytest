package edu.soft1.demo;
/**懒汉模式*/
public class SingletonA {
    private static final SingletonA s = new SingletonA();
    public static SingletonA getInstance(){
        return s;
    }

    public SingletonA() {
    }

//    @Override
//    public String toString() {
//        return "SingletonA{}";
//    }
}
