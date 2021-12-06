package edu.soft1.demo;

public class SingletonATest {
    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            System.out.println("饿汉"+(i+1)+SingletonA.getInstance());
        }
        System.out.println("\n");
        for (int i = 0; i < 5; i++) {
            System.out.println("懒汉"+(i+1)+SingletonB.getInstance());
        }
    }
}
