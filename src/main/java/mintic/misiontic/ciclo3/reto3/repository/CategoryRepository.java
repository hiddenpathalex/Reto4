/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hiddenpath
 */
@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }
    public Category update(Category c){
           Category existente = categoryCrudRepository.findById(c.getId()).orElse(null);
        existente.setName(c.getName());
        existente.setDescription(c.getDescription());
        return categoryCrudRepository.save(existente); 
    }
    
    public void delete(int id){
       categoryCrudRepository.deleteById(id);
    }
    public void deleteCategory(int id){
       categoryCrudRepository.deleteById(id);
    }
}
