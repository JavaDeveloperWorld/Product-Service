package com.example.village.service.message;

import com.example.village.dao.message.MessageRepository;
import com.example.village.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    public void insertMessage(Message message){
        messageRepository.insertMessage(message);
    }
    public void answerMessage(Message message){messageRepository.answerMessage(message);}
    public List<Message> getUserMessage(String email,Integer limit,Integer offset){
        if(limit==null){
            limit = 10;
        }
        if(offset==null){
            offset = 0;
        }
        return messageRepository.getUserMessage(email,limit, offset);
    }
    public List<Message>getUserLastMessage(String email){
        return messageRepository.getUserLastMessage(email);
    }
    public List<Message>getAllList(){return messageRepository.getAllList();}
    public List<Message>getAllUnreadList(){return messageRepository.getAllUnreadList();}
}
