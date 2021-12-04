package edu.soft1.dao;

import edu.soft1.pojo.Topic;

import java.sql.SQLException;
import java.util.List;

public class TopicDaoTest {
    public static void main(String[] args) throws SQLException {
//        //1.获取方法的返回值
//        List<Topic> list = new TopicDao().findAllTopic();
//        //2.打印返回值到控制台
//        for (Topic tmp: list){
//            System.out.println(tmp);
//        }

 //2.测试findTopicByName方法
//        List<Topic> list2 = new TopicDao().findAllTopicByName("天气");
//for (Topic tmp:list2){
//    System.out.println(tmp);
//}
//    }


    //3.测试addTopic方法
boolean success = new TopicDao().addTopic("游戏");
if (success==true){
    System.out.println("添加成功");
}else {
    System.out.println("添加失败");
}


//        boolean success2 = new TopicDao().delTopic("3");
//        if (success2==true){
//            System.out.println("删除成功");
//        }else {
//            System.out.println("删除失败");
//        }


        boolean success3 = new TopicDao().updateTopic("5","视频");
        if (success3==true){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
}
}
