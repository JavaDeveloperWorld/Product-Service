package com.example.village.dao.message;

import com.example.village.model.Message;

import java.util.List;

public interface MessageRepository {
    public void insertMessage(Message message);
    public List<Message> getUserMessage(String email,int limit,int offset);
    public List<Message>getUserLastMessage(String email);
    public List<Message>getAllList();
    public List<Message>getAllUnreadList();
    public void answerMessage(Message message);
}
