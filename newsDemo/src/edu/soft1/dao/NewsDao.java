package edu.soft1.dao;

import edu.soft1.pojo.News;
import edu.soft1.util.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作数据表news
 */
public class NewsDao {
    List<News> list = new ArrayList<>();
    Connection conn = DaoFactory.getConn();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    public List<News> findAllNews() throws SQLException {
        List<News> List = new ArrayList<News>();
        String sql = "select * from news";
        //1连接数据库
        Connection conn = DaoFactory.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //2执行查询，获取结果集
        try{
             ps = conn.prepareStatement(sql);

             rs = ps.executeQuery();
            while(rs.next()){
                //3.解析结果集，每一条数据封装入一个News对象，并将其添加到list中
                News news = new News(
                        rs.getString("nId"),
                        rs.getString("nTid"),
                        rs.getString("nTitle"),
                        rs.getString("nAuthor"),
                        rs.getString("nCreateDate"),
                        rs.getString("nPicPath"),
                        rs.getString("nContent"),
                        rs.getString("nModifyDate"),
                        rs.getString("nSummary"));
                List.add(news);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
//        finally {
//            DaoFactory.closeConn(conn,ps,rs);
//        }
        return List;
    }




    public List<News> findNewsById(String nTid) throws SQLException {
        List<News> List = new ArrayList<News>();
        String sql = "SELECT * FROM news where ntid = ?";
        //1连接数据库
        Connection conn = DaoFactory.getConn();
        //2执行查询，获取结果集
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
             ps = conn.prepareStatement(sql);
            ps.setString(1,nTid);
             rs = ps.executeQuery();
            while (rs.next()){
                List.add(new News(
                        rs.getString("nId"),
                        rs.getString("nTid"),
                        rs.getString("nTitle"),
                        rs.getString("nAuthor"),
                        rs.getString("nCreateDate"),
                        rs.getString("nPicPath"),
                        rs.getString("nContent"),
                        rs.getString("nModifyDate"),
                        rs.getString("nSummary")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DaoFactory.closeConn(conn,ps,rs);
        }
        return List;
    }

    public int totalCount(){
        int count = 0;
        try{
            sql = "select count(*) from news";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                count = Integer.parseInt(rs.getObject(1).toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }


    public List<News> getPageNewsList(int currPageNo,int pageSize){
        String sql = "Select * from news limit "+(currPageNo-1)*pageSize+","+pageSize;
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                News news = new News(
                        rs.getString("nId"),
                        rs.getString("nTid"),
                        rs.getString("nTitle"),
                        rs.getString("nAuthor"),
                        rs.getString("nCreateDate"),
                        rs.getString("nPicPath"),
                        rs.getString("nContent"),
                        rs.getString("nModifyDate"),
                        rs.getString("nSummary")

                );
                list.add(news);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}