/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.misiontic.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Hiddenpath
 */
@Entity
@Table(name="message")
public class Message implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
    @OneToOne
    @JoinColumn(name = "cabin")
    @JsonIgnoreProperties("messages")
    private Cabin cabin;
    
    @OneToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties("messages")
    private Client client;
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
    

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    
    
}
