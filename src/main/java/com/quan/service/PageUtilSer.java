package com.quan.service;

import com.quan.pojo.PageUtil;
import com.quan.pojo.User;

import java.util.List;

public interface PageUtilSer {
    int getTotalItem(int lessonId);
    List<User> page(int pageIndex, int pageSize, int lessonId);
    PageUtil<User> pageFind(int pageIndex, int pageSize, int lessonId, int totalItem);
}
