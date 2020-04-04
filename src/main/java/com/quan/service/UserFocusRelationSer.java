package com.quan.service;

import com.quan.pojo.UserFocusRelation;

import java.util.List;

public interface UserFocusRelationSer {
    List<UserFocusRelation> get();
    UserFocusRelation getById(int userFocusRelationId);
    List<UserFocusRelation> getByuserId(int userId);
    List<UserFocusRelation> getBytargetUserId(int targetUserId);
    UserFocusRelation getByRelation(int userId, int targetUserId);
    void add(UserFocusRelation userFocusRelation);
    void update(UserFocusRelation userFocusRelation);
    void delete(int userFocusRelationId);

}
