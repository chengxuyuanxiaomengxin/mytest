package edu.soft1.dao;

import edu.soft1.pojo.News;

import java.sql.SQLException;
import java.util.List;

class NewsDaoTest {
    public static void main(String[] args) throws SQLException {
        List<News> allNews = new NewsDao().findAllNews();
        for(News news:allNews){
            System.out.println(news);
        }
        System.out.println("******");
        //测试FindNewsById()方法
        List<News> news =  new NewsDao().findNewsById("1");
        for(News n:news){
            System.out.println(n);
        }
    }
}