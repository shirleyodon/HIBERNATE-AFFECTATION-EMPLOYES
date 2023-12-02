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
@Table(name="lieu")
public class Lieu implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CodeLieu")
    private int codeLieu;
    
    @Column(name="Designation", length=30, nullable=false)
    private String designation;
    
    @Column(name="Province", length=30, nullable=false)
    private String province;
    
    @OneToMany(mappedBy="codeAffectation.lieu", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Affectation> affectations=new HashSet();
    
    public Lieu(){}

    public Lieu(int codeLieu, String designation, String province) {
        this.codeLieu = codeLieu;
        this.designation = designation;
        this.province = province;
    }

    public Lieu(String designation, String province) {
        this.designation = designation;
        this.province = province;
    }

    public Lieu(int codeLieu) {
        this.codeLieu = codeLieu;
    }
    
    public int getCodeLieu() {
        return codeLieu;
    }
    
    public String getFormattedCodeLieu(){
        String format="L";
        if(codeLieu<10)
            format+="00"+codeLieu;
        else if(codeLieu<100)
            format+="0"+codeLieu;
        else
            format+=codeLieu;
        
        return format;
    }

    public void setCodeLieu(int codeLieu) {
        this.codeLieu = codeLieu;
    }
    
    public void setFormattedCodeLieu(String formattedCodeLieu){
        try{
            this.codeLieu=Integer.valueOf(formattedCodeLieu.substring(1));
        }catch(Exception ex){
            
        }
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Set<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(Set<Affectation> affectations) {
        this.affectations = affectations;
    }
    
    @Override
    public String toString() {
        return "Lieu{" + "codeLieu=" + getFormattedCodeLieu() + ", designation=" + designation + ", province=" + province + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.codeLieu;
        hash = 37 * hash + Objects.hashCode(this.designation);
        hash = 37 * hash + Objects.hashCode(this.province);
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
        
        final Lieu other = (Lieu) obj;
        if (this.codeLieu != other.getCodeLieu()) {
            return false;
        }
        if (!Objects.equals(this.designation, other.getDesignation())) {
            return false;
        }
        if (!Objects.equals(this.province, other.getProvince())) {
            return false;
        }
        
        return true;
    }
}
