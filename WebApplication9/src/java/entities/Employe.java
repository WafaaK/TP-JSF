/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author hp
 */
@Entity

public class Employe {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private String prenom;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaisssance;
    private String photo;

    
    @ManyToOne
    private Service service;
    
    @ManyToOne
    private Employe chef;
    
    public Employe() {
    }

    public Employe(String nom, String prenom, Date dateNaisssance, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaisssance = dateNaisssance;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaisssance() {
    return dateNaisssance;
}

public void setDateNaisssance(Date dateNaisssance) {
    this.dateNaisssance = dateNaisssance;
}

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employe getChef() {
        return chef;
    }

    public void setChef(Employe chef) {
        this.chef = chef;
    }

   
    

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaisssance=" + dateNaisssance + ", photo=" + photo + '}';
    }
    
    
}
