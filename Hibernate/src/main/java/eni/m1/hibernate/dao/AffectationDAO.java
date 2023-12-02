/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.dao;

import eni.m1.hibernate.entities.Affectation;
import eni.m1.hibernate.entities.CodeAffectation;
import eni.m1.hibernate.entities.Employe;
import eni.m1.hibernate.entities.Lieu;
import eni.m1.hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author shirleyodon
 */
public class AffectationDAO {
    private EmployeDAO edao=new EmployeDAO();
    private LieuDAO ldao=new LieuDAO();
    
    public List creerAffectation(String fce,String fcl, Date d){
    /**
     * fce: formatted code employe
     * fcl: formatted code lieu
     * d: date
     */
        List list=new ArrayList();
        Employe e=edao.obtenirEmploye(fce);
        if(e!=null){
            Lieu l=ldao.obtenirLieu(fcl);
            if(l!=null){
                try(Session session=HibernateUtil.getSessionFactory().openSession()){
                    CodeAffectation id=new CodeAffectation(e, l);
                    Affectation a=new Affectation(id, d);
                    Transaction tx=session.beginTransaction();
                    session.save(a);
                    tx.commit();
                    list.add(true);
                    list.add("La nouvelle affectation a été ajoutée avec succès !");
                }catch(Exception ex){
                    System.err.println("\nLa creation de l'affectation a echoue !\n"+ex);
                    list.add(false);
                    list.add("Une affectation de l'employé de code = '"+fce+"'\nvers le lieu de code = '"+fcl+"'\nexiste déjà dans la base de données !");
                }
            }else {list.add(false); list.add("Aucun lieu avec le code = '"+fcl+"' n'existe dans base de données !");}
        }else {list.add(false); list.add("Aucun(e) employé(e) avec le code = '"+fce+"' n'existe dans base de données !");}
        return list;
    }
    
    public List modifierAffectation(String cfce, String cfcl, String nfce, String nfcl, Date d){
    /**
    * cfce: current formatted code employe
    * cfcl: current formatted code lieu
    * nfce: new formatted code employe
    * nfcl: new formatted code lieu
    * ne: new employe
    * nl: new lieu
    * ca: current affectation
    */
        List list=new ArrayList();
        Employe ne=edao.obtenirEmploye(nfce);
        if(ne!=null){
            Lieu nl=ldao.obtenirLieu(nfcl);
            if(nl!=null){
                try(Session session=HibernateUtil.getSessionFactory().openSession()){
                    Transaction tx=session.beginTransaction();
                    CodeAffectation currentId=new CodeAffectation(edao.obtenirEmploye(cfce), ldao.obtenirLieu(cfcl));
                    CodeAffectation newId=new CodeAffectation(ne, nl);
                    Affectation ca=session.load(Affectation.class, currentId);
                    
                    if(!currentId.equals(newId)){
                        if(creerAffectation(nfce, nfcl, d).get(0).equals(true)) session.delete(ca);
                    }else{
                        ca.setDateAffectation(d);
                        session.update(ca);
                    }
                    tx.commit();
                    list.add(true);
                    list.add("Les modifications ont été enregistrées avec succès !");
                }catch(Exception ex){
                    System.err.println("\nLa mise a jour de l'affectation a echoue !\n"+ex);
                    list.add(false);
                    list.add("Aucune affectation associée au Code employé = '"+cfce+"' et au Code lieu = '"+cfcl+"'\nn'existe dans la base de données !");
                }
            }else {list.add(false); list.add("Aucun lieu avec le code = '"+nfcl+"' n'existe dans base de données !");}
        }else {list.add(false); list.add("Aucun(e) employé(e) avec le code = '"+nfce+"' n'existe dans base de données !");}
        return list;
    }
    
    public List supprimerAffectation(String fce, String fcl){
        List list=new ArrayList();
        Employe e=edao.obtenirEmploye(fce);
        if(e!=null){
            Lieu l=ldao.obtenirLieu(fcl);
            if(l!=null){
                try(Session session=HibernateUtil.getSessionFactory().openSession()){
                    Transaction tx=session.beginTransaction();
                    CodeAffectation id=new CodeAffectation(e, l);
                    Affectation a=session.load(Affectation.class, id);
                    session.delete(a);
                    tx.commit();
                    list.add(true);
                    list.add("L'affectation associée au Code employé = '"+fce+"' et au Code lieu = '"+fcl+"' a été supprimée avec succès !");
                }catch(Exception ex){
                    System.err.println("\nLa suppression de l'affectation a echoue !\n"+ex);
                    list.add(false);
                    list.add("Aucune affectation associée au Code employé = '"+fce+"' et au Code lieu = '"+fcl+"'\nn'existe dans la base de données !");
                }
            }else {list.add(false); list.add("Aucun lieu avec le code = '"+fcl+"' n'existe dans base de données !");}
        }else {list.add(false); list.add("Aucun(e) employé(e) avec le code = '"+fce+"' n'existe dans base de données !");}
        return list;
    }
    
    public boolean supprimerAffectationParEmploye(String fce){
        List list=listerAffectationParEmploye(fce);
        if(list.get(0)!=null){
            for(Object o: list){
                Affectation a=(Affectation)o;
                supprimerAffectation(fce, a.getLieu().getFormattedCodeLieu());
            }
            return true;
        }
        return false;
    }
    
    public boolean supprimerAffectationParLieu(String fcl){
        List list=listerAffectationParLieu(fcl);
        if(list.get(0)!=null){
            for(Object o: list){
                Affectation a=(Affectation)o;
                supprimerAffectation(a.getEmploye().getFormattedCodeEmploye(), fcl);
            }
            return true;
        }
        return false;
    }
    
    public List listerAffectation(){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            return session.createCriteria(Affectation.class)
                          .addOrder(Order.asc("codeAffectation"))
                          .list();
        }catch(Exception ex){
            System.err.println("\nLe listage de toutes les affectations a echoue !\n"+ex);
            return null;
        }
    }
    
    public List obtenirAffectation(String fce, String fcl){
        List list=new ArrayList();
        Employe e=edao.obtenirEmploye(fce);
        if(e!=null){
            Lieu l=ldao.obtenirLieu(fcl);
            if(l!=null){
                try(Session session=HibernateUtil.getSessionFactory().openSession()){
                    CodeAffectation id=new CodeAffectation(e, l);
                    Affectation a=(Affectation)session.createCriteria(Affectation.class)
                                                      .add(Restrictions.idEq(id))
                                                      .uniqueResult();
                    if(a!=null) list.add(a);
                    else{
                        list.add(null);
                        list.add("Aucune affectation associée au Code employé = '"+fce+"' et au Code lieu = '"+fcl+"' n'existe dans base de données !");
                    }   
                }catch(Exception ex){
                    System.err.println("\nL'obtention d'une affectation par son code a echoue !\n"+ex);
                }
            }else {list.add(null); list.add("Le lieu dont le code = '"+fcl+"' n'existe pas dans la base de données !");}
        }else {list.add(null); list.add("L'employé(e) dont le code = '"+fce+"' n'existe pas dans la base de données !");}
        return list;
    }
    
    public List listerAffectationParEmploye(String fce){
        List list=new ArrayList();
        Employe e=edao.obtenirEmploye(fce);
        if(e!=null){
            if(!e.getAffectations().isEmpty()){
                Iterator<Affectation> it=e.getAffectations().iterator();
                while(it.hasNext()) list.add(it.next());
            }else{list.add(null); list.add("Aucune affectation concernant l'employé(e) dont le code = '"+fce+"' n'a été trouvée !");}
        }else{list.add(null); list.add("L'employé(e) dont le code = '"+fce+"' n'existe pas dans la base de données !");}
        return list;
    }
    
    public List listerAffectationParLieu(String fcl){
        List list=new ArrayList();
        Lieu l=ldao.obtenirLieu(fcl);
        if(l!=null){
            if(!l.getAffectations().isEmpty()){
                Iterator<Affectation> it=l.getAffectations().iterator();
                while(it.hasNext()) list.add(it.next());
            }else{list.add(null); list.add("Aucune affectation associée au lieu dont le code = '"+fcl+"' n'a été trouvée !");}
        }else{list.add(null); list.add("Le lieu dont le code = '"+fcl+"' n'existe pas dans la base de données !");}
        return list;
    }
    
    public List listerAffectationParIntervalleDate(Date start, Date end){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            return session.createCriteria(Affectation.class)
                          .add(Restrictions.between("dateAffectation", start, end))
                          .addOrder(Order.asc("codeAffectation"))
                          .list();
        }catch(Exception ex){
            System.err.println("\nLe listage des affectations par intervalle de dates a echoue !\n"+ex);
            return null;
        }
    }
}
