/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Message;
import mintic.misiontic.ciclo3.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hiddenpath
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message m){
        if(m.getIdMessage() == null){
            return messageRepository.save(m);
        }else{
            Optional<Message> evt=messageRepository.getMessage(m.getIdMessage());
            if(evt.isEmpty()){
                return messageRepository.save(m);
            }
            return m;
        }
    }
    public Message update(Message m){
           return messageRepository.save(m);
    }
    public void delete(int id){
        messageRepository.delete(id);
    }
    public void deleteMessage(int id){
       messageRepository.delete(id);
    }
}
