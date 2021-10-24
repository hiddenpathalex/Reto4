/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import mintic.misiontic.ciclo3.reto3.model.Category;
import mintic.misiontic.ciclo3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hiddenpath
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category c){
        if(c.getId() == null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> evt=categoryRepository.getCategory(c.getId());
            if(evt.isEmpty()){
                return categoryRepository.save(c);
            }
            return c;
        }
    }
    public Category update(Category c){
           return categoryRepository.save(c);
    }
    public void delete(int id){
        categoryRepository.delete(id);
    }
    public void deleteCategory(int id){
       categoryRepository.delete(id);
    }
}
