package com.quan.service;

import com.quan.pojo.PrivateMessage;

import java.util.List;

public interface PrivateMessageSer {
    List<PrivateMessage> get();
    PrivateMessage getById(int privateMessageId);
    List<PrivateMessage> getByTargetUserId(int privateMessageId);
    void add(PrivateMessage privateMessage);
    void update(PrivateMessage privateMessage);
    void delete(int privateMessageId);
}
