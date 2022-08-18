package com.example.village.service.message;

import com.example.village.model.Message;

import java.util.List;

public interface MessageService {
    public void insertMessage(Message message);
    public List<Message> getUserMessage(String email,Integer limit,Integer offset);
    public List<Message>getUserLastMessage(String email);
    public List<Message>getAllList();
    public List<Message>getAllUnreadList();
    public void answerMessage(Message message);
}
