/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hiddenpath
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    public Message save(Message m){
        return messageCrudRepository.save(m);
    }
    public Message update(Message m){
           Message existente = messageCrudRepository.findById(m.getIdMessage()).orElse(null);
        existente.setMessageText(m.getMessageText());
        return messageCrudRepository.save(existente); 
    }
    
    public void delete(int id){
       messageCrudRepository.deleteById(id);
    }
    public void deleteMessage(int id){
       messageCrudRepository.deleteById(id);
    }
}
