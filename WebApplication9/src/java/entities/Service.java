/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Lachgar
 */


@Entity
public class Service {
    
    @Id
    @GeneratedValue
    
    private long id;
    private String nom;
   // @OneToMany
   // private List<Employe> employes;
    public Service() {
    }

    public Service(String nom) {
        this.nom = nom;
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

//    public List<Employe> getEmployes() {
//        return employes;
//    }
//
//    public void setEmployes(List<Employe> employes) {
//        this.employes = employes;
//    }
    

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", nom=" + nom + '}';
    }

    
    
}