package edu.soft1.demo;

public class SingletonB {
    /**
     * 懒汉模式
     */

        private static SingletonB S = null;
        public static SingletonB getInstance(){
            if (S == null) {
                S = new SingletonB();
            }
            return S;
        }
}
