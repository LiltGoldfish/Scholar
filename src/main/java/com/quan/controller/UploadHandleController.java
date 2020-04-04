package com.quan.controller;

import com.quan.pojo.Homework;
import com.quan.pojo.StudentHomeworkRelation;
import com.quan.pojo.User;
import com.quan.service.HomeworkBiz;
import com.quan.service.StudentHomeworkRelationBiz;
import com.quan.util.ContextUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class UploadHandleController {
    @Autowired
    public  StudentHomeworkRelationBiz studentHomeworkRelationBiz/* = ContextUtil.getContext().getBean("studentHomeworkRelationBiz", StudentHomeworkRelationBiz.class)*/;
    @Autowired
    public  HomeworkBiz homeworkBiz /*= ContextUtil.getContext().getBean("homeworkBiz", HomeworkBiz.class)*/;

    @RequestMapping("/UploadHandleServlet")
    public void uploadHandle(HttpServletRequest request, HttpServletResponse response, MultipartFile file1) throws IOException {
        int homeworkId = 0;
        int lessonId = 0;
        User user = null;
        String src = "";
        // 得到上传头像的保存目录，将上传的文件存放于/resource/user目录下
        ServletContext context = request.getServletContext();
        String savePath = context.getRealPath("/resource/homework");

        //从session中获取用户对象
        if((User)request.getSession().getAttribute("user") != null){
            user = (User)request.getSession().getAttribute("user");
        }

        File file = new File(savePath);
        // 判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");
            // 创建目录
            file.mkdir();
        }

        if(!file1.isEmpty()) {
            String filename = file1.getOriginalFilename();//获取上传时的文件名称
            filename = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(filename);//创建一个新的文件名称    getExtension(name):获取文件后缀名
            File f = new File(savePath, filename);
            file1.transferTo(f);//将上传的文件存储到指定位置
            src = "resource/homework/"+filename ;
        }
        homeworkId = Integer.parseInt (request.getParameter("homeworkId"));
        lessonId = Integer.parseInt (request.getParameter("lessonId"));
        StudentHomeworkRelation byLessonIdHomeworkId = studentHomeworkRelationBiz.getByLessonIdHomeworkId(user.getUserId(), homeworkId);
        if(byLessonIdHomeworkId==null){
            StudentHomeworkRelation studentHomeworkRelation = new StudentHomeworkRelation();
            studentHomeworkRelation.setStudent(user);
            studentHomeworkRelation.setScore(0);
            studentHomeworkRelation.setSubmitTime(new Date());
            studentHomeworkRelation.setHomework(homeworkBiz.getById(homeworkId));
            studentHomeworkRelation.setSrc(src);
            studentHomeworkRelationBiz.add(studentHomeworkRelation);
        }
        else{
            byLessonIdHomeworkId.setSrc(src);
            studentHomeworkRelationBiz.update(byLessonIdHomeworkId);
        }
        List<StudentHomeworkRelation> studentHomeworkList = studentHomeworkRelationBiz.getHomeworkByStudentId(user.getUserId(),lessonId);
        List<Homework> studentHomeworkNotList = homeworkBiz.getByLessonIdNot(user.getUserId(),lessonId);
        request.getSession().setAttribute("studentHomeworkNotList", studentHomeworkNotList);
        request.getSession().setAttribute("studentHomework", studentHomeworkList);
        response.sendRedirect("home/lessonDetail.jsp");
    }
}
