/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.controler;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Cabin;
import mintic.misiontic.ciclo3.reto3.services.CabinServicio;
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
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CabinController {
    
    @Autowired
    private CabinServicio cabinService;
    
    @GetMapping("/all")
    public List<Cabin> getCabins(){
        return cabinService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cabin> getCabin(@PathVariable("id") int id){
        return cabinService.getCabin(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin c){
        return cabinService.save(c);
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Cabin c){
        cabinService.update(c);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Cabin c){
        cabinService.delete(c.getId());
        return ResponseEntity.status(204).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCabin(@PathVariable("id") Cabin c){
        cabinService.deleteCabin(c.getId());
        return ResponseEntity.status(204).build();
    }
    
}
