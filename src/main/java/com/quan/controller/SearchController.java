package com.quan.controller;

import com.quan.pojo.Lesson;
import com.quan.pojo.PageUtil;
import com.quan.pojo.User;
import com.quan.service.LessonBiz;
import com.quan.service.UserBiz;
import com.quan.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SearchController {
    private long serialVersionUID ;
    @Autowired
    public  LessonBiz lessonBiz /*= ContextUtil.getContext().getBean("lessonBiz", LessonBiz.class)*/;
    @Autowired
    public  UserBiz userBiz /*= ContextUtil.getContext().getBean("userBiz", UserBiz.class)*/;

    @RequestMapping("/SearchSer")
    public void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
        serialVersionUID = 1L;
        String path = request.getContextPath();

        String type = "";
        String searchString = "";
        int pageIndex = 1;
        int pageSize = 10;

        if (request.getParameter("type") != null) {
            type = request.getParameter("type");
        }
        if (request.getParameter("searchString") != null) {
            searchString = request.getParameter("searchString");
        }
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
            pageIndex = (pageIndex < 1) ? 1 : pageIndex;
        }
        if (request.getParameter("pageSize") != null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            pageSize = (pageSize < 1) ? 1 : pageSize;
        }

        if (type.equals("Lesson")) {
            LessonBiz lessonBiz = ContextUtil.getContext().getBean("lessonBiz", LessonBiz.class);
            PageUtil<Lesson> lessonPage = lessonBiz.getSearchLessonPage(searchString, pageIndex, pageSize);

            request.getSession().setAttribute("type", "Lesson");
            request.getSession().setAttribute("searchString", searchString);
            request.getSession().setAttribute("page", lessonPage);
        } else if (type.equals("User")) {
            UserBiz userBiz =ContextUtil.getContext().getBean("userBiz", UserBiz.class);
            PageUtil<User> userPage = userBiz.getSearchUserPage(searchString, pageIndex, pageSize);

            request.getSession().setAttribute("type", "User");
            request.getSession().setAttribute("searchString", searchString);
            request.getSession().setAttribute("page", userPage);
        } else {
            request.getSession().removeAttribute("type");
            request.getSession().removeAttribute("searchString");
            request.getSession().removeAttribute("page");
        }

        response.sendRedirect(path + "/search.jsp");
    }
    public void init() throws ServletException {
    }
}
