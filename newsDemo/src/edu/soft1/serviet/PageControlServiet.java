package edu.soft1.serviet;

import edu.soft1.dao.NewsDao;
import edu.soft1.pojo.News;
import edu.soft1.util.page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PageControlServiet", value = "/PageControlServiet")
public class PageControlServiet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        page pages = new page();
        NewsDao newsDao = new NewsDao();
        String pageIndex = request.getParameter("pageIndex");//url地址中的当前页码
        System.out.println("pageIndex=" + pageIndex);
        if (pageIndex == null) {//没有pageIndex参数
            pageIndex = "1";//若没有获取页码，设置为首页
        }
        int currPageNo = Integer.parseInt(pageIndex);//设置当前页
        System.out.println("currPageNo=" + currPageNo);
        if (currPageNo < 1) {//当前页不可小于1
            currPageNo = 1;
        }
//        else if (currPageNo > pages.getTotalPageCount()){//当前页不可大于末页
//            currPageNo = pages.getTotalPageCount();
//        }else {
//            currPageNo = pages.getTotalPageCount();
//        }
        pages.setCurrPageNo(currPageNo);//设置page对象当前页
        int totalCount = newsDao.totalCount();//查询获取News总记录数
        pages.setPageSize(2);//设置pages对象每页显示几条
        pages.setTotalCount(totalCount);//设置pages对象总记录数
        pages.setTotalPageCount(pages.getTotalCount());//设置pages对象页数
        System.out.println("88888"+pages.getTotalPageCount());
        List<News> newList = newsDao.getPageNewsList(pages.getCurrPageNo(), pages.getPageSize());
        for (News news : newList) {
            System.out.println(news);
        }
        pages.setNewsList(newList);//设置pages对象newlist的值
        request.setAttribute("pages", pages);//将pages存入request
        request.getRequestDispatcher("newspages/admin.jsp").forward(request, response);
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doGet(request,response);
    }

    private class NewsServiceImpl extends NewsSerivce {
    }
}
