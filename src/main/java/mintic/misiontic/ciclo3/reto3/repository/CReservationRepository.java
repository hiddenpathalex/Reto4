/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.CalificacionReservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hiddenpath
 */
@Repository
public class CReservationRepository {
    @Autowired
    private CReservationCrudRepository cReservationCrudRepository;
    
    public List<CalificacionReservas> getAll(){
        return (List<CalificacionReservas>) cReservationCrudRepository.findAll();
    }
    
    public Optional<CalificacionReservas> getCalificacionReservas(int id){
        return cReservationCrudRepository.findById(id);
    }
    
    public CalificacionReservas save(CalificacionReservas c){
        return cReservationCrudRepository.save(c);
    }
    
    public CalificacionReservas update(CalificacionReservas c){
           CalificacionReservas existente = cReservationCrudRepository.findById(c.getIdScore()).orElse(null);
        existente.setMessage(c.getMessage());
        existente.setScore(c.getScore());
        return cReservationCrudRepository.save(existente); 
    }
    
    public void delete(int id){
       cReservationCrudRepository.deleteById(id);
    }
    public void deleteCReservation(int id){
       cReservationCrudRepository.deleteById(id);
    }
}
