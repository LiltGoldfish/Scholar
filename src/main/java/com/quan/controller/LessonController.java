package com.quan.controller;

import com.quan.pojo.*;
import com.quan.service.*;
import com.quan.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class LessonController {
    @Autowired
    public  LessonBiz lessonBiz /*= ContextUtil.getContext().getBean("lessonBiz",LessonBiz.class)*/;
    @Autowired
    public  MajorBiz majorBiz ;/* =  ContextUtil.getContext().getBean("majorBiz",MajorBiz.class);*/
    @Autowired
    public  UserBiz userBiz ; /*= ContextUtil.getContext().getBean("userBiz",UserBiz.class);*/
    @Autowired
    public  DepartmentBiz departmentBiz ;/*= ContextUtil.getContext().getBean("departmentBiz",DepartmentBiz.class);*/
    @Autowired
    public  StudentLessonRelationBiz studentLessonRelationBiz ; /*= ContextUtil.getContext().getBean("studentLessonRelationBiz",StudentLessonRelationBiz.class);*/

    @RequestMapping("/LessonSer")
    public void lesson(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String method = null;
        if (request.getParameter("method") != null) {
            method = request.getParameter("method");
        }

        if(method == null){
            int lessonId = Integer.parseInt(request.getParameter("lessonId"));
            Lesson lesson = lessonBiz.getById(lessonId);
            request.setAttribute("lesson", lesson);
            List<Department> departmentList =  departmentBiz.get();
            List<Major> majorList = majorBiz.getByDepartmentId(lesson.getMajor().getDepartment().getDepartmentId());
            User uuser = null;
            if((User)request.getSession().getAttribute("user") != null){
                uuser = (User)request.getSession().getAttribute("user");
                StudentLessonRelation studentLessonRelation = studentLessonRelationBiz.getByRelation(uuser.getUserId(), lessonId);
                request.setAttribute("studentLessonRelation", studentLessonRelation);
            }
            request.setAttribute("departmentListt", departmentList);
            request.setAttribute("majorListt", majorList);
            request.getRequestDispatcher("lesson.jsp").forward(request, response);
        }else if(method.equals("major")){
            int departmentId = Integer.parseInt(request.getParameter("departmentId"));
            System.out.println(departmentId);
            List<Major> list = majorBiz.getByDepartmentId(departmentId);
            PrintWriter out = response.getWriter();
            int num = 0;
            for (Major major : list) {
                if(num == 0){
                    out.print("<option selected='selected' value='" + major.getMajorId() + "'>" + major.getMajorName() + "</option>");
                    num++;
                }else{
                    out.print("<option value='" + major.getMajorId() + "'>" + major.getMajorName() + "</option>");
                }
            }
        }else if (method.equals("createLesson")) {

            int teacherId = 0;
            int majorId = 0;
            String lessonName = "";
            String lessonIntroduction = "";
            String lessonAnnouncement = "";
            String lessonPictureUrl = "";

            if(request.getParameter("teacherId") != null) {
                teacherId = Integer.parseInt(request.getParameter("teacherId"));
            }
            if(request.getParameter("majorId") != null) {
                majorId = Integer.parseInt(request.getParameter("majorId"));
            }
            if(request.getParameter("lessonName") != null) {
                lessonName = request.getParameter("lessonName");
            }
            if(request.getParameter("lessonIntroduction") != null) {
                lessonIntroduction = request.getParameter("lessonIntroduction");
            }
            if(request.getParameter("lessonAnnouncement") != null) {
                lessonAnnouncement = request.getParameter("lessonAnnouncement");
            }



            MajorBiz majorBiz =  ContextUtil.getContext().getBean("majorBiz", MajorBiz.class);

            Lesson lesson = new Lesson();

            lesson.setTeacher(userBiz.getById(teacherId));
            lesson.setMajor(majorBiz.getById(majorId));
            lesson.setLessonName(lessonName);
            lesson.setLessonIntroduction(lessonIntroduction);
            lesson.setLessonAnnouncement(lessonAnnouncement);
            lesson.setLessonPictureUrl("resource/lesson/0.jpg");
            LessonBiz lessonBiz = ContextUtil.getContext().getBean("lessonBiz", LessonBiz.class);

            lessonBiz.add(lesson);


            response.sendRedirect("LessonSer?lessonId=" + lesson.getLessonId());
            return ;
        }else if(method.equals("add")){
            int studentId = 0;
            int lessonId = 0;
            if(request.getParameter("studentId") != null) {
                studentId = Integer.parseInt(request.getParameter("studentId"));
            }
            if(request.getParameter("lessonId") != null) {
                lessonId = Integer.parseInt(request.getParameter("lessonId"));
            }
            StudentLessonRelation studentLessonRelation = new StudentLessonRelation();
            studentLessonRelation.setLesson(lessonBiz.getById(lessonId));
            studentLessonRelation.setStudent(userBiz.getById(studentId));
            studentLessonRelationBiz.add(studentLessonRelation);
            response.sendRedirect("LessonDetailSer?lessonId=" + lessonId);
        }
    }
}
