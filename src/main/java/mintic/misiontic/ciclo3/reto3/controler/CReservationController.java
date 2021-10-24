/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.controler;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.CalificacionReservas;
import mintic.misiontic.ciclo3.reto3.services.CReservationService;
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
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CReservationController {
    @Autowired
    private CReservationService cReservationService;
    
    @GetMapping("/all")
    public List<CalificacionReservas> getCalificacionReservas(){
        return cReservationService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<CalificacionReservas> getCalificacionReservas(@PathVariable("id") int id){
        return cReservationService.getCalificacionReservas(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity save(@RequestBody CalificacionReservas c){
        cReservationService.save(c);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody CalificacionReservas c){
        cReservationService.update(c);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody CalificacionReservas c){
        cReservationService.delete(c.getIdScore());
        return ResponseEntity.status(204).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCReservation(@PathVariable("id") CalificacionReservas c){
        cReservationService.deleteCReservation(c.getIdScore());
        return ResponseEntity.status(204).build();
    }
}
