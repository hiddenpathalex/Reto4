/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hiddenpath
 */
@Repository
public class CabinRepository {
    
    @Autowired
    private CabinCrudRepository cabinCrudRepository;
    
    public List<Cabin> getAll(){
        return (List<Cabin>) cabinCrudRepository.findAll();
    }
    
    public Optional<Cabin> getCabin(int id){
        return cabinCrudRepository.findById(id);
    }
    
    public Cabin save(Cabin c){
        return cabinCrudRepository.save(c);
    }
    public Cabin update(Cabin c){
           Cabin existente = cabinCrudRepository.findById(c.getId()).orElse(null);
        existente.setBrand(c.getBrand());
        existente.setRooms(c.getRooms());
        existente.setName(c.getName());
        existente.setDescription(c.getDescription());
        return cabinCrudRepository.save(existente); 
    }
    
    public void delete(int id){
       cabinCrudRepository.deleteById(id);
    }
    
    public void deleteCabin(int id){
       cabinCrudRepository.deleteById(id);
    }
}
