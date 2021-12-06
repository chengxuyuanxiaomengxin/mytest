package edu.soft1.dao;

import edu.soft1.pojo.Topic;
import edu.soft1.util.DaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * topic表的增删改查
 */
public class TopicDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 查询所有的topic
     * @return
     */
    public List<Topic> findAllTopic(){
        List<Topic> list = new ArrayList<Topic>();
        //1.连接数据库
        conn = DaoFactory.getConn();
        System.out.println("findAllTopic中的conn"+conn);
        try {
            ps = conn.prepareStatement("select * from topic");
            System.out.println("111");
            //2.查询结果
            rs = ps.executeQuery();

            //3.解析结果集
            while (rs.next()){
                //封装为Topic对象
                Topic topic = new Topic(rs.getString("tid"),
                        rs.getString("tname"));
                //4.Topic对象添加到返回值list中
                list.add(topic);
                System.out.println("222");
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
//        finally {
//            DaoFactory.closeConn(conn,ps,rs);//关闭数据库连接
//        }

        return  list;
    }

    /**
     * 根据tname查询topic
     * @param tname
     * @return
     */
    public  List<Topic> findTopicByName(String tname) {
        List<Topic> list = new ArrayList<Topic>();
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("select * from topic where tname = ?");
            ps.setString(1,tname);
            rs = ps.executeQuery();
            while (rs.next()){
                //封装为Topic对象
                Topic topic = new Topic(rs.getString("tid"),
                        rs.getString("tname"));
                //4.Topic对象添加到返回值list中
                list.add(topic);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
//        finally {
//            DaoFactory.closeConn(conn,ps,rs);//关闭数据库连接
//        }

        return list;
    }

    /**
     * 添加
     * @param tname
     * @return
     */
    public boolean addTopic(String tname){
        boolean flag = false;
       // int rows = 0;
        //1.连接数据库
        conn= DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("insert into topic(tname) VALUES(?);");
            ps.setString(1,tname);
            flag = ps.executeUpdate() ==1;
//            if (rows !=0){
//                flag = true;
//            }
        }catch (SQLException e){
            e.printStackTrace();
        }
//        finally {
//            DaoFactory.closeConn(conn,ps,rs);//关闭数据库连接
//        }
        return flag;
    }

    /**
     * 删除
     * @param tid
     * @return
     */
    public boolean delTopic(String tid){
        boolean flag = false;
        //int rows = 0;
        //1.连接数据库
        conn= DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("delete from topic where tid = ?;");
            ps.setString(1,tid);
            flag = ps.executeUpdate() ==1;
           // rows = ps.executeUpdate();
//            if (rows !=0){
//                flag = true;
//            }
        }catch (SQLException e){
            e.printStackTrace();
        }
//        finally {
//            DaoFactory.closeConn(conn,ps,rs);//关闭数据库连接
//        }

        return flag;
    }

    /**
     * 修改
     * @param tid
     * @param tname
     * @return
     */
    public boolean updateTopic(String tid ,String tname){
        boolean flag = false;
       // int rows = 0;
        //1.连接数据库
        conn= DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("update topic set tname =? where tid=?");
            ps.setString(1,tname);
            ps.setString(2,tid);
            flag = ps.executeUpdate() ==1;
//            rows = ps.executeUpdate();
//            if (rows !=0){
//                flag = true;
//            }
        }catch (SQLException e){
            e.printStackTrace();
        }
//        finally {
//            DaoFactory.closeConn(conn,ps,rs);//关闭数据库连接
//        }

        return flag;
    }
}
