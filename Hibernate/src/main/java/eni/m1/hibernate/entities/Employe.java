/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author shirleyodon
 */

@Entity
@Table(name="employe")
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CodeEmploye")
    private int codeEmploye;
    
    @Column(name="Nom", length=30, nullable=false)
    private String nom;
    
    @Column(name="Prenom", length=30, nullable=false)
    private String prenom;
    
    @Column(name="Poste", length=30, nullable=false)
    private String poste;
    
    @OneToMany(mappedBy="codeAffectation.employe", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Affectation> affectations=new HashSet();
    
    public Employe(){}

    public Employe(int codeEmploye) {
        this.codeEmploye = codeEmploye;
    }

    public Employe(int codeEmploye, String nom, String prenom, String poste) {
        this.codeEmploye = codeEmploye;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    public Employe(String nom, String prenom, String poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    public int getCodeEmploye() {
        return codeEmploye;
    }
    
    public String getFormattedCodeEmploye(){
        String format="E";
        if(codeEmploye<10)
            format+="00"+codeEmploye;
        else if(codeEmploye<100)
            format+="0"+codeEmploye;
        else
            format+=codeEmploye;
        
        return format;
    }

    public void setCodeEmploye(int codeEmploye) {
        this.codeEmploye = codeEmploye;
    }
    
    public void setFormattedCodeEmploye(String formattedCodeEmploye){
        try{
            this.codeEmploye=Integer.valueOf(formattedCodeEmploye.substring(1));
        }catch(Exception ex){
            System.err.println("\nCodeEmploye invalide !\n"+ex);
        }
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Set<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(Set<Affectation> affectations) {
        this.affectations = affectations;
    }
    
    @Override
    public String toString() {
        return "Employe{" + "codeEmploye=" + getFormattedCodeEmploye() + ", nom=" + nom + ", prenom=" + prenom + ", poste=" + poste + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.codeEmploye;
        hash = 19 * hash + Objects.hashCode(this.nom);
        hash = 19 * hash + Objects.hashCode(this.prenom);
        hash = 19 * hash + Objects.hashCode(this.poste);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Employe other = (Employe) obj;
        if (this.codeEmploye != other.getCodeEmploye()) {
            return false;
        }
        if (!Objects.equals(this.nom, other.getNom())) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.getPrenom())) {
            return false;
        }
        if (!Objects.equals(this.poste, other.getPoste())) {
            return false;
        }
        
        return true;
    }
}
