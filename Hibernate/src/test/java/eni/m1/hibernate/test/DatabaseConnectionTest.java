/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author shirleyodon
 */
public class DatabaseConnectionTest {
    private Connection con;
    private String url="jdbc:mysql://localhost/gest_affect_employe",
                    login="root",
                    pwd="";
    
    public DatabaseConnectionTest(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion a la base de donnees etablie");
            
        }catch(SQLException | ClassNotFoundException ex){
            System.err.println("Connexion a la base de donnees echoue");
        }
    }
        
    public static void main(String[] args){
        DatabaseConnectionTest con=new DatabaseConnectionTest();
    }
}
