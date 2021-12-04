package edu.soft1.dao;
import edu.soft1.pojo.User;
import edu.soft1.util.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDao {
    Connection conn = DaoFactory.getConn();
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 查询用户
     */
    public User findUser(String username, String upwd) {
        User user = null;

        String sql = "select * from news_user where username=? and upwd=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, upwd);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setUid(rs.getString("uid"));
                user.setUsername(rs.getString("username"));
                user.setUpwd(rs.getString("upwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    /**
     * 通过用户名查询用户
     */

    public int findUserByName(String username) {
        int flag = 0;
        String sql = "select * from news_user where username = ?";
        Connection conn = DaoFactory.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                flag = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("findUserByName返回值=" + flag);
        return flag;//0:无此用户；1：有此用户
    }



    public boolean addUser(String username,String upwd) {
        boolean flag = false;
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("insert into news_user(username,upwd) VALUES(?,?);");
            ps.setString(1,username);
            ps.setString(2,upwd);
            flag = ps.executeUpdate()==1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }
}
