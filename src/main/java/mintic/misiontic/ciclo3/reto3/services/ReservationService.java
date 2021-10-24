/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Reservation;
import mintic.misiontic.ciclo3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hiddenpath
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation r){
        if(r.getIdReservation() == null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> evt=reservationRepository.getReservation(r.getIdReservation());
            if(evt.isEmpty()){
                return reservationRepository.save(r);
            }
            return r;
        }
    }
    public Reservation update(Reservation r){
           return reservationRepository.save(r);
    }
    public void delete(int id){
        reservationRepository.delete(id);
    }
    public void deleteReservation(int id){
       reservationRepository.delete(id);
    }
}
