package com.quan.controller;

import com.quan.pojo.Homework;
import com.quan.pojo.Lesson;
import com.quan.service.HomeworkBiz;
import com.quan.service.LessonBiz;
import com.quan.service.TimeAssistBiz;
import com.quan.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class ReleaseHomeworkController {
    @Autowired
    public  LessonBiz lessonBiz /*= ContextUtil.getContext().getBean("lessonBiz", LessonBiz.class)*/;
    @Autowired
    public  HomeworkBiz homeworkBiz /*= ContextUtil.getContext().getBean("homeworkBiz", HomeworkBiz.class)*/;
    public  TimeAssistBiz timeAssistBiz ;
    @RequestMapping("/ReleaseHomeworkSer")
    public void releaseHomework(HttpServletRequest request,HttpServletResponse response){
        timeAssistBiz = new TimeAssistBiz();
        /***发布作业并存到数据库****/
            int lessonId = Integer.parseInt(request.getParameter("lessonId"));
            String homeworkName = request.getParameter("homeworkName");
            String homeworkContent = request.getParameter("homeworkContent");
            String homeworkStartTime = request.getParameter("homeworkStartTime");
            int homeworkEndTime = Integer.parseInt(request.getParameter("homeworkEndTime"));//作业期限(多少天)

            Lesson lesson = lessonBiz.getById(lessonId);

            Homework homework = new Homework();
            homework.setLesson(lesson);
            homework.setHomeworkName(homeworkName);
            homework.setHomeworkContent(homeworkContent);

            Date startTime = timeAssistBiz.getDateTimeByString(homeworkStartTime);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(startTime);
            calendar.add(Calendar.DATE, homeworkEndTime);
            Date endTime = calendar.getTime();

            homework.setHomeworkStartTime(startTime);
            homework.setHomeworkEndTime(endTime);
            homeworkBiz.add(homework);
            /*************************/
        }
}
