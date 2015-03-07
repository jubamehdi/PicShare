/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import entity.Login;
import entity.Metadonnee;
import java.io.File;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author User
 */
public class DataQuery {

    EntityManagerFactory enf;
    EntityManager em;

    public DataQuery() {
        enf = Persistence.createEntityManagerFactory("Login_ExamplePU");
        em = enf.createEntityManager();
        em.getTransaction().begin();

    }

    public boolean loginControl(String username, String password) {
        try {
            Login l = em.createNamedQuery("Login.control", Login.class).setParameter("username", username).setParameter("password", password).getSingleResult();
            if (l != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean createControl(String username, String password, String nom, String prenom) {

        try {
            
            Login nouveau = new Login(username, password, nom, prenom);
            em.persist(nouveau);
            em.flush();
            return true;
        } catch (Exception e) {
            System.err.println("createControle : creation user  block catch");
            return false;
        }
    }

    public boolean metadataControl(Metadonnee metadonnee) {
        em.persist(metadonnee);
        em.flush();
        //em.getTransaction().commit();
        return true;
    }
}
