/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.controler;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Cabin;
import mintic.misiontic.ciclo3.reto3.model.Message;
import mintic.misiontic.ciclo3.reto3.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hiddenpath
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message m){
        return messageService.save(m);
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Message m){
        messageService.update(m);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Message m){
        messageService.delete(m.getIdMessage());
        return ResponseEntity.status(204).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMessage(@PathVariable("id") Message m){
        messageService.deleteMessage(m.getIdMessage());
        return ResponseEntity.status(204).build();
    }
}
