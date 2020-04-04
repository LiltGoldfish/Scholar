package com.quan.controller;

import com.quan.pojo.PrivateMessage;
import com.quan.pojo.User;
import com.quan.service.PrivateMessageBiz;
import com.quan.service.TimeAssistBiz;
import com.quan.service.UserBiz;
import com.quan.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
public class PrivateMessageController {
    @Autowired
    public  UserBiz userBiz /*= ContextUtil.getContext().getBean("userBiz",UserBiz.class)*/;
    @Autowired
    public  TimeAssistBiz timeAssistBiz /*= new TimeAssistBiz()*/;
    @Autowired
    public  PrivateMessageBiz privateMessageBiz /*= ContextUtil.getContext().getBean("privateMessageBiz",PrivateMessageBiz.class)*/;

    @RequestMapping("/PrivateMessageSer")
    public void PrivateMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int targetUserId = Integer.parseInt(request.getParameter("targetUserId"));
        String privateMessageContent = request.getParameter("privateMessageContent");

        PrivateMessage privateMessage = new PrivateMessage();
        User user = userBiz.getById(userId);
        User targetUser = userBiz.getById(targetUserId);
        privateMessage.setUser(user);
        privateMessage.setTargetUser(targetUser);
        privateMessage.setReaded(true);
        privateMessage.setPrivateMessageTime(new Date());
        privateMessage.setPrivateMessageContent(privateMessageContent);
        privateMessageBiz.add(privateMessage);
        PrintWriter out = response.getWriter();
        out.print("block");
    }
}
