/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.CalificacionReservas;
import mintic.misiontic.ciclo3.reto3.repository.CReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hiddenpath
 */
@Service
public class CReservationService {
    @Autowired
    private CReservationRepository cReservationRepository;
    
    public List<CalificacionReservas> getAll(){
        return cReservationRepository.getAll();
    }
    
    public Optional<CalificacionReservas> getCalificacionReservas(int id){
        return cReservationRepository.getCalificacionReservas(id);
    }
    
    public CalificacionReservas save(CalificacionReservas c){
        if(c.getIdScore() == null){
            return cReservationRepository.save(c);
        }else{
            Optional<CalificacionReservas> evt=cReservationRepository.getCalificacionReservas(c.getIdScore());
            if(evt.isEmpty()){
                return cReservationRepository.save(c);
            }
            return c;
        }
    }
    public CalificacionReservas update(CalificacionReservas c){
           return cReservationRepository.save(c);
    }
    public void delete(int id){
        cReservationRepository.delete(id);
    }
    public void deleteCReservation(int id){
       cReservationRepository.delete(id);
    }
}
