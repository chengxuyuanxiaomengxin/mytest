package edu.soft1.serviet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTest", value = "/ServletTest")
public class ServletTest extends HttpServlet {
//    public ServletTest() {
//        super();
//    }


    @Override
    public void init() throws ServletException {
        System.out.println("ServletTset初始化。。。");
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }



    /**
     *
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /***/
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/**
 * 销毁
 * */
    }
}
