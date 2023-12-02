/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.dao;

import eni.m1.hibernate.entities.Employe;
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
public class EmployeDAO {
    private List<Employe> retireDoublon(List list){
        if(list==null) return null;
        else if(list.isEmpty()) return list;
        else{
            List<Employe> newList=new ArrayList();
            for(Object e: list){
                if(!newList.contains((Employe)e)) newList.add((Employe)e);
            }
            return newList;
        } 
    }
    
    public boolean creerEmploye(String n, String p, String ps){
        /**
         * n: nom
         * p: prenom
         * ps: poste
         */
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            Employe e=new Employe(n, p, ps);
            Transaction tx=session.beginTransaction();
            session.save(e);
            tx.commit();
            return true;
        }catch(Exception ex){
            System.err.println("\nLa creation de l'employe a echoue !\n"+ex);
            return false;
        }
    }
    
    public boolean mettreAjourEmploye(String fce, String n, String p, String ps){
        /**
         * fce: Formatted Code Employe
         */
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            Transaction tx=session.beginTransaction();
            int codeEmploye=Integer.valueOf(fce.substring(1));
            Employe e=session.load(Employe.class, codeEmploye);
            
            if(!e.getNom().equals(n)) e.setNom(n);
            if(!e.getPrenom().equals(p)) e.setPrenom(p);
            if(!e.getPoste().equals(ps)) e.setPoste(ps);
            
            session.update(e);
            tx.commit();
            return true;
        }catch(Exception ex){
            System.err.println("\nLa mise a jour de l'employe a echoue !\n"+ex);
            return false;
        }
    }
    
    public boolean supprimerEmploye(String fce){
        /**
         * ce: code employe
         */
        AffectationDAO dao=new AffectationDAO();
        dao.supprimerAffectationParEmploye(fce);
        
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            Transaction tx=session.beginTransaction();
            int ce=Integer.valueOf(fce.substring(1));
            Employe e=session.load(Employe.class, ce);
            session.delete(e);
            tx.commit();
            return true;
        }catch(Exception ex){
            System.err.println("\nLa suppression de l'employe a echoue !\n"+ex);
            return false;
        }
    }
    
    public List listerEmploye(){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            List list= session.createCriteria(Employe.class)
                              .addOrder(Order.asc("codeEmploye"))
                              .list();
            return retireDoublon(list);
        }catch(Exception ex){
            System.err.println("\nLe listage de tous les employes a echoue !\n"+ex);
            return null;
        }
    }
    
    public Employe obtenirEmploye(String fce){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            int ce=Integer.valueOf(fce.substring(1));
            return (Employe)session.createCriteria(Employe.class)
                                   .add(Restrictions.idEq(ce))
                                   .uniqueResult();
        }catch(Exception ex){
            System.err.println("\nL'obtention d'un employe par son code a echoue !\n"+ex);
            return null;
        }
    }
    
    public Employe obtenirEmploye(String n, String p, String ps){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            return (Employe)session.createCriteria(Employe.class)
                                   .add(Restrictions.and(
                                        Restrictions.eq("nom", n),
                                        Restrictions.eq("prenom", p),
                                        Restrictions.eq("poste", ps)))
                                   .uniqueResult();
        }catch(Exception ex){
            System.err.println("\nL'obtention d'un employe par son nom, son prenom et son poste a echoue !\n"+ex);
            return null;
        }
    }
    
    public List listerEmployeParMotCle(String kw){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            List list= session.createCriteria(Employe.class)
                              .add(Restrictions.or(
                                    Restrictions.ilike("nom", kw, MatchMode.ANYWHERE), 
                                    Restrictions.ilike("prenom", kw, MatchMode.ANYWHERE),
                                    Restrictions.ilike("poste", kw, MatchMode.ANYWHERE)))
                              .addOrder(Order.asc("codeEmploye"))
                              .list();
            return retireDoublon(list);
        }catch(Exception ex){
            System.err.println("\nLe listage d'employes par mot clé a echoue !\n"+ex);
            return null;
        }
    }
}
