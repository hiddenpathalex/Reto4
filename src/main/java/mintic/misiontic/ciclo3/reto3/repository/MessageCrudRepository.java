/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.repository;

import mintic.misiontic.ciclo3.reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Hiddenpath
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
