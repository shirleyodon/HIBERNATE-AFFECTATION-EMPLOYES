/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.test;

import eni.m1.hibernate.dao.*;
import eni.m1.hibernate.entities.*;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;


/**
 *
 * @author shirleyodon
 */
public class Test {
    public static void main(String[] args){
        LieuDAO dao=new LieuDAO();
        dao.supprimerLieu("L012");
    }
    
    private static Date setDate(String d){
        try {
            SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
            return format.parse(d);
        } catch (ParseException ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    private static void listage(List<Object> list){
        System.out.println("\n");
        if(list==null) System.out.println("Liste NULL");
        else if(list.isEmpty()) System.out.println("Liste VIDE");
        else{
            for(Object o: list)
                System.out.println(o.toString());
        }
    }
    
    private static void listage(Object o){
        System.out.println("\n");
        if(o==null) System.out.println("Objet VIDE");
        else System.out.println(o.toString());
    }
}
