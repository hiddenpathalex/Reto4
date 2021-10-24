/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Cabin;
import mintic.misiontic.ciclo3.reto3.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hiddenpath
 */
@Service
public class CabinServicio {
    
    @Autowired
    private CabinRepository cabinRepository;
    
    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }
    
    public Optional<Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }
    
    public Cabin save(Cabin c){
        if(c.getId() == null){
            return cabinRepository.save(c);
        }else{
            Optional<Cabin> evt=cabinRepository.getCabin(c.getId());
            if(evt.isEmpty()){
                return cabinRepository.save(c);
            }
            return c;
        }
    }
    public Cabin update(Cabin c){
           return cabinRepository.save(c);
    }
    public void delete(int id){
        cabinRepository.delete(id);
    }
    public void deleteCabin(int id){
       cabinRepository.delete(id);
    }
}
