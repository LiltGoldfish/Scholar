package com.quan.controller;

import com.quan.pojo.Lesson;
import com.quan.pojo.User;
import com.quan.pojo.UserFocusRelation;
import com.quan.service.*;
import com.quan.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SelfController {
    @Autowired
    public  UserBiz userBiz /*= ContextUtil.getContext().getBean("userBiz", UserBiz.class)*/;
    @Autowired
    public  StudentLessonRelationBiz studentLessonRelationBiz /*= ContextUtil.getContext().getBean("studentLessonRelationBiz", StudentLessonRelationBiz.class)*/;
    @Autowired
    public  LessonBiz lessonBiz /*= ContextUtil.getContext().getBean("lessonBiz", LessonBiz.class)*/;
    @Autowired
    public  TimeAssistBiz timeAssistBiz = new TimeAssistBiz();
    @Autowired
    public  UserFocusRelationBiz userFocusRelationBiz /*= ContextUtil.getContext().getBean("userFocusRelationBiz", UserFocusRelationBiz.class)*/;

    @RequestMapping("/SelfSer")
    public void self(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userBiz.getById(userId);

        User uuser = null;
        if((User)request.getSession().getAttribute("user") != null){
            uuser = (User)request.getSession().getAttribute("user");
            //你和正在查看的用户之间是否关注了
            UserFocusRelation userFocusRelation = userFocusRelationBiz.getByRelation(uuser.getUserId(), userId);
            request.setAttribute("userFocusRelation", userFocusRelation);
        }

        List<Lesson> lessonList = null;
        if(user.getUserType().equals("学生")){
            lessonList = studentLessonRelationBiz.getByStudentId(user.getUserId());
        }else{
            lessonList = lessonBiz.getByTeacherId(user.getUserId());
        }
        request.setAttribute("usser", user);
        request.setAttribute("lessonListt", lessonList);
        request.getRequestDispatcher("self.jsp").forward(request, response);
    }
}
