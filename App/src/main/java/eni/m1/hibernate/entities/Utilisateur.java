/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author shirleyodon
 */
@Entity
@Table(name="utilisateur")
public class Utilisateur implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    
    @Column(name="Login", length=30, nullable=false)
    private String login;
    
    @Column(name="Password", length=30, nullable=false)
    private String password;
    
    @Column(name="Statut", length=10, nullable=false)
    private String statut;

    public Utilisateur() {}
    
    public Utilisateur(int id, String login, String password, String statut) {
        this.id=id;
        this.login = login;
        this.password = password;
        this.statut=statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        String hiddenPwd="";
        for(int i=0; i<password.length(); i++)
            hiddenPwd+="*";
        return "Utilisateur{" + "login=" + login + ", password=" + hiddenPwd + ", statut=" + statut + '}';
    }
}
