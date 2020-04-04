package com.quan.controller;

import com.quan.pojo.User;
import com.quan.pojo.UserFocusRelation;
import com.quan.service.UserBiz;
import com.quan.service.UserFocusRelationBiz;
import com.quan.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class FocusController {
    @Autowired
    public  UserFocusRelationBiz userFocusRelationBiz; /*= ContextUtil.getContext().getBean("userFocusRelationBiz",UserFocusRelationBiz.class);*/
    @Autowired
    public  UserBiz userBiz ; /*= ContextUtil.getContext().getBean("userBiz",UserBiz.class);*/

    @RequestMapping("/FocusSer")
    public void focusSer(HttpServletRequest request, HttpServletResponse response){
        String method = null;
        if (request.getParameter("method") != null) {
            method = request.getParameter("method");
        }
        if(method == null){
            int userId = Integer.parseInt(request.getParameter("userId"));
            int userFocusRelationId = Integer.parseInt(request.getParameter("userFocusRelationId"));
            userFocusRelationBiz.delete(userFocusRelationId);
            User user = userBiz.getById(userId);
            List<UserFocusRelation> focusList = userFocusRelationBiz.getByuserId(user.getUserId());
            request.getSession().setAttribute("focusList", focusList);
        }else if(method.equals("add")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            int targetUserId = Integer.parseInt(request.getParameter("targetUserId"));
            UserFocusRelation userFocusRelation = new UserFocusRelation();
            userFocusRelation.setUser(userBiz.getById(userId));
            userFocusRelation.setTargetUser(userBiz.getById(targetUserId));
            userFocusRelationBiz.add(userFocusRelation);
            List<UserFocusRelation> focusList = userFocusRelationBiz.getByuserId(userId);
            request.getSession().setAttribute("focusList", focusList);
        }
    }
}
