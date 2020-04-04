package com.quan.controller;

import com.quan.pojo.PageUtil;
import com.quan.pojo.User;
import com.quan.service.PageUtilBiz;
import com.quan.service.UserBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LessonStudentListController {
    @RequestMapping("/LessonStudentListSer")
    public void lessonStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBiz biz = new UserBiz();
        PageUtilBiz pa=new PageUtilBiz();
        int index=1;
        if(request.getParameter("index")!=null)
            index=Integer.parseInt(request.getParameter("index"));

        // 调用业务逻辑层方法，获取多底层返回的数据集合
        PageUtil<User> pu = pa.pageFind(index, 1, 1, pa.getTotalItem(1));
        request.setAttribute("pageUtil", pu); // 把数据存储在Request作用域中
        // 转发页面
        request.getRequestDispatcher("home/userList.jsp").forward (request,response);
    }
}
