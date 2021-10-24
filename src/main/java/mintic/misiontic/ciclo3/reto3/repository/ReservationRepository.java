/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hiddenpath
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);
    }
    public Reservation update(Reservation r){
           Reservation existente = reservationCrudRepository.findById(r.getIdReservation()).orElse(null);
        existente.setStartDate(r.getStartDate());
        existente.setDevolutionDate(r.getDevolutionDate());
        return reservationCrudRepository.save(existente); 
    }
    
    public void delete(int id){
       reservationCrudRepository.deleteById(id);
    }
    public void deleteReservation(int id){
       reservationCrudRepository.deleteById(id);
    }
}
