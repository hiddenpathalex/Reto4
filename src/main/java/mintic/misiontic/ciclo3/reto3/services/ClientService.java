/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Client;
import mintic.misiontic.ciclo3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hiddenpath
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    public Client save(Client c){
        if(c.getIdClient() == null){
            return clientRepository.save(c);
        }else{
            Optional<Client> evt=clientRepository.getClient(c.getIdClient());
            if(evt.isEmpty()){
                return clientRepository.save(c);
            }
            return c;
        }
    }
    public Client update(Client c){
           return clientRepository.save(c);
    }
    public void delete(int id){
        clientRepository.delete(id);
    }
    public void deleteClient(int id){
       clientRepository.delete(id);
    }
}
