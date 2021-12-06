package edu.soft1.serviet;

import edu.soft1.dao.TopicDao;

import edu.soft1.pojo.Topic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TopicListServlet", value = "/TopicListServlet")
public class TopicListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Topic> list = new TopicDao().findAllTopic();
//        for (Topic topic:list
//             ) {
//            System.out.println(topic);
//        }
        request.getSession().setAttribute("allTopics",list);
        response.sendRedirect("PageControlServiet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
