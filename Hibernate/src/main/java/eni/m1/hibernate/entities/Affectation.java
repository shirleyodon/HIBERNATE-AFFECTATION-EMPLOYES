/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author shirleyodon
 */
@Entity
@Table(name="affectation")
public class Affectation implements Serializable{
    @Id
    @Column(name="CodeAffectation", nullable=false)
    private CodeAffectation codeAffectation;
    
    @Column(name="DateAffectation", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dateAffectation;
    
    public Affectation() {}
    
    public Affectation(CodeAffectation codeAffectation, Date date) {
        this.codeAffectation = codeAffectation;
        this.dateAffectation = date;
    }

    public CodeAffectation getCodeAffectation() {
        return codeAffectation;
    }

    public void setCodeAffectation(CodeAffectation codeAffectation) {
        this.codeAffectation = codeAffectation;
    }

    public Date getDateAffectation() {
        return dateAffectation;
    }
    
    public String getFormattedDateAffectation(){
        try{
            SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
            return format.format(dateAffectation);
        }catch(Exception ex){
            System.err.println("\nErreur de la methode getFormattedDateAffectation() de l' objet affectation !\n"+ex);
            return null;
        }
    }

    public void setDateAffectation(Date date) {
        this.dateAffectation = date;
    }
    
    public Employe getEmploye(){
        return this.codeAffectation.getEmploye();
    }
    
    public void setEmploye(Employe e){
        this.codeAffectation.setEmploye(e);
    }
    
    public Lieu getLieu(){
        return this.codeAffectation.getLieu();
    }
    
    public void setLieu(Lieu l){
        this.codeAffectation.setLieu(l);
    }

    @Override
    public String toString() {
        try{
            SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
            return "Affectation{"
                        +"codeEmploye=" + this.getEmploye().getFormattedCodeEmploye()
                        +", codeLieu="+this.getLieu().getFormattedCodeLieu()
                        +", dateAffectation="+this.getFormattedDateAffectation()+
                    "}";
        }catch(Exception ex){
            System.err.println("\nErreur de la methode toString de l' objet affectation!\n"+ex);
            return null;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + ((this.codeAffectation==null)? 0: this.codeAffectation.hashCode());
        hash = 73 * hash + Objects.hashCode(this.dateAffectation);
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
        final Affectation other = (Affectation) obj;
        if(this.codeAffectation==null){
            if(other.getCodeAffectation()!=null)
                return false;
        }else if(!this.codeAffectation.equals(other.getCodeAffectation()))
            return false;
        
        if (!Objects.equals(this.dateAffectation, other.getDateAffectation())) {
            return false;
        }
        return true;
    }
}
