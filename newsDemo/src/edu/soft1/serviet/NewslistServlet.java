package edu.soft1.serviet;

import edu.soft1.dao.NewsDao;
import edu.soft1.pojo.News;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NewslistServlet", value = "/NewslistServlet")
public class NewslistServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> list = new NewsDao().findAllNews();
        HttpSession session = request.getSession();
        session.setAttribute("allNews",list);
//        Cookie[] cookies = request.getCookies();//
        response.sendRedirect("TopicListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("NewslistServlet的Dopost");
        this.doGet(request,response);
    }
}
