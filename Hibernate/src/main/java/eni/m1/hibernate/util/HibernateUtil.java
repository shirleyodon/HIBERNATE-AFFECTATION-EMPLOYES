/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.util;

import eni.m1.hibernate.entities.Affectation;
import eni.m1.hibernate.entities.Employe;
import eni.m1.hibernate.entities.Lieu;
import eni.m1.hibernate.entities.Utilisateur;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author shirleyodon
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;
    
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try{
                StandardServiceRegistryBuilder registryBuilder=new StandardServiceRegistryBuilder();

                Map<String, String> settings=new HashMap<>();
                settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                settings.put("hibernate.connection.url", "jdbc:mysql://localhost/gest_affect_employe");
                settings.put("hibernate.connection.username", "root");
                settings.put("hibernate.connection.password", "");
                settings.put("hibernate.show_sql", "true");
                settings.put("hibernate.hbm2ddl.auto", "update");

                registryBuilder.applySettings(settings);
                registry = registryBuilder.build();

                MetadataSources sources = new MetadataSources(registry)
                                            .addAnnotatedClass(Employe.class)
                                            .addAnnotatedClass(Lieu.class)
                                            .addAnnotatedClass(Affectation.class)
                                            .addAnnotatedClass(Utilisateur.class);

                sessionFactory = sources.buildMetadata().buildSessionFactory();
            }catch(Exception ex){
                System.out.println("\nLa creation de la SessionFactory a echouee !!\n"+ex);
                if (registry != null)
                    StandardServiceRegistryBuilder.destroy(registry);
            }
        }
        return sessionFactory;
    }
    
    public static void shutdown() {
      if (registry != null)
         StandardServiceRegistryBuilder.destroy(registry);
   }
}
