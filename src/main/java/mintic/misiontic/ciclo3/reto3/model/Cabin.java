/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hiddenpath
 */
@Entity
@Table(name="cabin")
public class Cabin implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer rooms;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("cabins")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties("cabin")
    private List<Message> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties("cabin")
    private List<Reservation> Reservations;

    public List<Reservation> getReservations() {
        return Reservations;
    }

    public void setReservations(List<Reservation> Reservations) {
        this.Reservations = Reservations;
    }

    
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
