package com.quan.controller;

import com.quan.dao.CoursewareDao;
import com.quan.pojo.Courseware;
import com.quan.service.CoursewareBiz;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class CoursewareController {
    @Autowired
    CoursewareBiz coursewareBiz;

    @RequestMapping("/CoursewareController")
    public void service(HttpServletRequest request, HttpServletResponse response , MultipartFile file1) throws IOException, ServletException {
        String method = "";
        method = request.getParameter("method");
        if(method.equals("upload")){
           Integer lessonId = null;
           String coursewareName = "";
           String src = "";
           if(request.getParameter("coursewareName")!=null){
               coursewareName= request.getParameter("coursewareName");
           }
           if(request.getSession().getAttribute("lessonId")!=null){
               lessonId = (Integer) request.getSession().getAttribute("lessonId");
           }
            // 得到上传课件的保存目录，将上传的文件存放于/resource/courseware目录下
            ServletContext context = request.getServletContext();
            String savePath = context.getRealPath("/resource/courseware");

            File file = new File(savePath);
            // 判断上传文件的保存目录是否存在
            if (!file.exists() && !file.isDirectory()) {
                System.out.println(savePath + "目录不存在，需要创建");
                // 创建目录
                file.mkdir();
            }

            if(!file1.isEmpty()){
                String filename = file1.getOriginalFilename();//获取上传时的文件名称
                File f = new File(savePath, filename);
                file1.transferTo(f);//将上传的文件存储到指定位置
                src = "resource/courseware/"+filename ;
            }
            coursewareBiz.add(new Courseware(null,lessonId,coursewareName,new Date(),src));
            List<Courseware> coursewareList = coursewareBiz.getByLessonID(lessonId);
            request.getSession().setAttribute("coursewareList",coursewareList);
            request.getRequestDispatcher("home/lessonDetail.jsp#courseware").forward(request, response);
        }
    }

    @RequestMapping("/deleteCourseware")
    public void delete(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        int coursewareID = Integer.parseInt(request.getParameter("coursewareID"));
        coursewareBiz.deleteById(coursewareID);
        Integer lessonId = (Integer) request.getSession().getAttribute("lessonId");
        List<Courseware> coursewareList = coursewareBiz.getByLessonID(lessonId);
        request.getSession().setAttribute("coursewareList",coursewareList);
        request.getRequestDispatcher("home/lessonDetail.jsp#courseware").forward(request, response);
    }

}
