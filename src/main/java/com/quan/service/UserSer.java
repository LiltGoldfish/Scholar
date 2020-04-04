package com.quan.service;

import com.quan.pojo.PageUtil;
import com.quan.pojo.User;

import java.util.List;

public interface UserSer {
    List<User> get();
    User getById(int userId);
    User getByUserUsername(String userUsername);
    void add(User user);
    void update(User user);
    void delete(int userId);
    PageUtil<User> getSearchUserPage(String searchString, int pageIndex, int pageSize);


}
