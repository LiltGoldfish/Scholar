package com.quan.service;

import com.quan.pojo.Message;
import com.quan.util.MessageUtil;

import java.util.List;

public interface MessageSer {
    List<Message> get();
    Message getById(int MessageId);
    List<Message> getByParentMessageId(int parentMessageId);
    void add(Message Message);
    void update(Message Message);
    void delete(int MessageId);
    List<MessageUtil> getByLessonId(int lessonId);
}
