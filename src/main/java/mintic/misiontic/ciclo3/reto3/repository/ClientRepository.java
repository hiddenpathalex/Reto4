/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hiddenpath
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    
    public Client save(Client c){
        return clientCrudRepository.save(c);
    }
    public Client update(Client c){
           Client existente = clientCrudRepository.findById(c.getIdClient()).orElse(null);
        existente.setEmail(c.getEmail());
        existente.setPassword(c.getPassword());
        existente.setName(c.getName());
        existente.setAge(c.getAge());
        return clientCrudRepository.save(existente); 
    }
    
    public void delete(int id){
       clientCrudRepository.deleteById(id);
    }
    public void deleteClient(int id){
       clientCrudRepository.deleteById(id);
    }
}
