package edu.soft1.dao;

import edu.soft1.pojo.News;
import edu.soft1.util.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoimpl {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    public int getTotalCount() {
        System.out.println("进入getTotalCount");
        int count = 0;
        String sql = "select count(*) from news";
        try {
            conn = DaoFactory.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = Integer.parseInt(rs.getObject(1).toString());
            }
            System.out.println("count=" + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

    }

    public List<News> getPageNewsList(int currPageNo, int pageSize) {
        List<News> newsList = new ArrayList<News>();
        String sql = "select * from news limit " + (currPageNo - 1) * pageSize + "," + pageSize;
        System.out.println("sql=" + sql);
        try {
            conn = DaoFactory.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                newsList.add(new News(
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;

    }
}
