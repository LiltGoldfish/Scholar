package com.quan.controller;

import com.quan.pojo.User;
import com.quan.service.TimeAssistBiz;
import com.quan.service.UserBiz;
import com.quan.util.ContextUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
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
public class UserUpdateController {
    @RequestMapping("/UserUpdateSer")
    public void userUpdate(HttpServletRequest request,HttpServletResponse response, MultipartFile file1) throws IOException {

        // 得到上传头像的保存目录，将上传的文件存放于/resource/user目录下
        ServletContext context = request.getSession().getServletContext();
        String savePath = context.getRealPath("/resource/user");

        UserBiz biz = ContextUtil.getContext().getBean("userBiz",UserBiz.class);

        //从session中获取用户对象
        User user = (User)request.getSession().getAttribute("user");

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
            String userPictureUrl = "resource/user/"+filename ;
            user.setUserPictureUrl(userPictureUrl);
        }

		String userName = request.getParameter("userName");
		String userType = request.getParameter("userType");
		String userAddress = request.getParameter("userAddress");
		TimeAssistBiz timeAssistBiz = new TimeAssistBiz();
		Date userBirthday = timeAssistBiz.getDateByString(request.getParameter("userBirthday"));
		String userEmail = request.getParameter("userEmail");
		String userIntroduction = request.getParameter("userIntroduction");
		String userPhone = request.getParameter("userPhone");
		String userSchool = request.getParameter("userSchool");
		int userAge = Integer.parseInt(request.getParameter("userAge"));

		user.setUserName(userName);
		user.setUserType(userType);
		user.setUserAddress(userAddress);
		user.setUserAge(userAge);
		user.setUserBirthday(userBirthday);
		user.setUserEmail(userEmail);
		user.setUserIntroduction(userIntroduction);
		user.setUserPhone(userPhone);
		user.setUserSchool(userSchool);
        biz.update(user);

        response.sendRedirect("home/home.jsp");

    }

}
