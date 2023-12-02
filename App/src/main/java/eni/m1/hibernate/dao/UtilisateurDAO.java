/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.dao;

import eni.m1.hibernate.entities.Utilisateur;
import eni.m1.hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author shirleyodon
 */
public class UtilisateurDAO {
    public List obtenirUtilisateur(String login, String pwd){
        List list=new ArrayList();
        list.add(false);
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            Utilisateur u= (Utilisateur)session.createCriteria(Utilisateur.class)
                                               .add(Restrictions.eq("login", login))
                                               .uniqueResult();
            if(u!=null){
                if(u.getPassword().equals(pwd)){
                    list.remove(0);
                    list.add(true);
                    list.add(u);
                }else list.add("Le mot de passe est incorrect !");
            }else list.add("L'utilisateur est inconnu du système !");
        }catch(Exception ex){
            System.err.println("\nL'obtention d'un utilisateur par son Login et son Password a echoue !\n"+ex);
            return null;
        }
        return list;
    }
}
