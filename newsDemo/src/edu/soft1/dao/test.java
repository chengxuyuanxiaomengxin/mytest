package edu.soft1.dao;

import edu.soft1.pojo.News;

import java.util.List;

public class test {
    public static void main(String[] args) {
        NewsDaoimpl ne = new NewsDaoimpl();
        int us = ne.getTotalCount();
        System.out.println("us"+us);

        List<News> news = ne.getPageNewsList(1,2);
        for (News new1:news){
            System.out.println(new1);
        }
    }
}
