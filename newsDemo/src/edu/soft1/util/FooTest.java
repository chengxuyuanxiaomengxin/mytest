//package edu.soft1.util;
//
//import java.lang.reflect.Method;
//
//public class FooTest {
//
//    public static void main(String[] args) {
//        Foo foo = new Foo();
//        foo.hello();
//        try {
//            Object foo = Class.forName("edu.soft1.util.Foo").newInstance();
//            //Object foo1 =edu.soft1.util.Foo.class.newInstance();
//            Method m = foo.getClass().getDeclaredMethod("hello",new Class<?>[0]);
//            m.invoke(foo);
//        }catch (ClassNotFoundException | NoSuchMethodException |){
//            System.out.println("失败");
//            e.printStackTrace();
//        }
//    }
//}
