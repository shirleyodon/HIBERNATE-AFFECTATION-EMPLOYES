/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author shirleyodon
 */
@Embeddable
public class CodeAffectation implements Serializable{
    @ManyToOne()
    @JoinColumn(name="CodeEmploye")
    private Employe employe;
    
    @ManyToOne()
    @JoinColumn(name="CodeLieu")
    private Lieu lieu;
    
    public CodeAffectation(){}
    
    public CodeAffectation(Employe employe, Lieu lieu){
        this.employe=employe;
        this.lieu=lieu;
    }
    
    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + ((this.employe==null)? 0: this.employe.hashCode());
        hash = 29 * hash + ((this.lieu==null)? 0: this.lieu.hashCode());
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
        final CodeAffectation other = (CodeAffectation) obj;
        if(this.employe==null){
            if(other.getEmploye()!=null)
                return false;
        }else if(!this.employe.equals(other.getEmploye()))
            return false;
        if(this.lieu==null){
            if(other.getLieu()!=null)
                return false;
        }else if(!this.lieu.equals(other.getLieu()))
            return false;
        
        return true;
    }
    
}
