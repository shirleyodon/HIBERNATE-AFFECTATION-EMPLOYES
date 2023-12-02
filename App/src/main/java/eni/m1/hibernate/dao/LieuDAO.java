/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.dao;

import eni.m1.hibernate.entities.Lieu;
import eni.m1.hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author shirleyodon
 */
public class LieuDAO {
    private List<Lieu> retireDoublon(List list){
        if(list==null) return null;
        else if(list.isEmpty()) return list;
        else{
            List<Lieu> newList=new ArrayList();
            for(Object l: list){
                if(!newList.contains((Lieu)l)) newList.add((Lieu)l);
            }
            return newList;
        } 
    }
    
    public boolean creerLieu(String d, String p){
        /**
         * d: designation
         * p: province
         */
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            Lieu l=new Lieu(d, p);
            Transaction tx=session.beginTransaction();
            session.save(l);
            tx.commit();
            return true;
        }catch(Exception ex){
            System.err.println("\nLa creation du lieu a echoue !\n"+ex);
            return false;
        }
    }
    
    public boolean mettreAjourLieu(String fcl, String d, String p){
        /**
         * fcl: formatted code lieu
         */
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            Transaction tx=session.beginTransaction();
            int codeLieu=Integer.valueOf(fcl.substring(1));
            Lieu l=session.load(Lieu.class, codeLieu);
            
            if(!l.getDesignation().equals(d)) l.setDesignation(d);
            if(!l.getProvince().equals(p)) l.setProvince(p);
            
            session.update(l);
            tx.commit();
            return true;
        }catch(Exception ex){
            System.err.println("\nLa mise a jour du lieu a echoue !\n"+ex);
            return false;
        }
    }
    
    public boolean supprimerLieu(String fcl){
        /**
         * cl: code lieu
         */
        AffectationDAO dao=new AffectationDAO();
        dao.supprimerAffectationParLieu(fcl);
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            Transaction tx=session.beginTransaction();
            int cl=Integer.valueOf(fcl.substring(1));
            Lieu l=session.load(Lieu.class, cl);
            session.delete(l);
            tx.commit();
            return true;
        }catch(Exception ex){
            System.err.println("\nLa suppression du lieu a echoue !\n"+ex);
            return false;
        }
    }
    
    public List listerLieu(){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            List list= session.createCriteria(Lieu.class)
                              .addOrder(Order.asc("codeLieu"))
                              .list();
            return retireDoublon(list);
        }catch(Exception ex){
            System.err.println("\nLe listage de tous les lieux a echoue !\n"+ex);
            return null;
        }
    }
    
    public Lieu obtenirLieu(String fcl){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            int codeLieu=Integer.valueOf(fcl.substring(1));
            return (Lieu)session.createCriteria(Lieu.class)
                                   .add(Restrictions.idEq(codeLieu))
                                   .uniqueResult();
        }catch(Exception ex){
            System.err.println("\nL'obtention d'un lieu par son code a echoue !\n"+ex);
            return null;
        }
    }
    
    public Lieu obtenirLieu(String d, String p){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            return (Lieu)session.createCriteria(Lieu.class)
                          .add(Restrictions.and(
                                Restrictions.eq("designation", d),
                                Restrictions.eq("province", p)))
                          .uniqueResult();
        }catch(Exception ex){
            System.err.println("\nL'obtention d'un lieu par sa designation et sa province a echoue !\n"+ex);
            return null;
        }
    }
    
    public List listerLieuParMotCle(String kw){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            List list = session.createCriteria(Lieu.class)
                               .add(Restrictions.or(
                                      Restrictions.ilike("designation", kw, MatchMode.ANYWHERE), 
                                      Restrictions.ilike("province", kw, MatchMode.ANYWHERE)))
                               .addOrder(Order.asc("codeLieu"))
                               .list();
            return retireDoublon(list);
        }catch(Exception ex){
            System.err.println("\nLe listage de lieux par mot clé a echoue !\n"+ex);
            return null;
        }
    }
}
