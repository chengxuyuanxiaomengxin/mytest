package edu.soft1.dao;

public class TestUserDao {
    public static void main(String[] args) {
        int row = new UserDao().findUserByName("peter");
        if(row == 1){
            System.out.println("111111");
        }else {
            System.out.println("000000");
        }
    }


}
