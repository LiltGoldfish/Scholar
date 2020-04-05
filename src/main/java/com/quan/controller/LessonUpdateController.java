package com.quan.controller;

import com.quan.pojo.Lesson;
import com.quan.service.LessonBiz;
import com.quan.service.MajorBiz;
import com.quan.service.UserBiz;
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
import java.util.List;
import java.util.UUID;

@Controller
public class LessonUpdateController {
    @Autowired
    public  UserBiz userBiz /*= ContextUtil.getContext().getBean("userBiz",UserBiz.class)*/;
    @Autowired
    public  LessonBiz lessonBiz /*= ContextUtil.getContext().getBean("lessonBiz",LessonBiz.class)*/;
    @Autowired
    public  MajorBiz majorBiz /*=  ContextUtil.getContext().getBean("majorBiz",MajorBiz.class)*/;

    @RequestMapping("/LessonUpdateSer")
    public void lessonUpdate(HttpServletRequest request, HttpServletResponse response , MultipartFile file1) throws IOException {
        int lessonId = Integer.parseInt(request.getParameter("lessonId"));
        Lesson lesson = lessonBiz.getById(lessonId);

        // 得到上传头像的保存目录，将上传的文件存放于/resource/user目录下
        ServletContext context = request.getSession().getServletContext();
        String savePath = context.getRealPath("/resource/lesson");

        File file = new File(savePath);
        // 判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");
            // 创建目录
            file.mkdir();
        }

        if(!file1.isEmpty()){
            String filename = file1.getOriginalFilename();//获取上传时的文件名称
            filename = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(filename);//创建一个新的文件名称    getExtension(name):获取文件后缀名
            File f = new File(savePath, filename);
            file1.transferTo(f);//将上传的文件存储到指定位置
            String lessonPictureUrl = "resource/lesson/"+filename ;
            lesson.setLessonPictureUrl(lessonPictureUrl);
        }

        String lessonName =  request.getParameter("lessonName");
        String majorId = request.getParameter("majorId");
        String lessonIntroduction =  request.getParameter("lessonIntroduction");
        String lessonAnnouncement =  request.getParameter("lessonAnnouncement");


        lesson.setLessonAnnouncement(lessonAnnouncement);
        lesson.setLessonName(lessonName);
        lesson.setMajor(majorBiz.getById(Integer.parseInt(majorId)));
        lesson.setLessonIntroduction(lessonIntroduction);

        lessonBiz.update(lesson);
        response.sendRedirect("LessonSer?lessonId=" + lessonId);
    }
}
