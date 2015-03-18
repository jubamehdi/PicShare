/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import entity.Login;
import entity.Metadonnee;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author User
 */
public class DataQuery implements Serializable{

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

    public List<Metadonnee> selectAll() {
        List<Metadonnee> liste = new ArrayList<>();
        try {
            liste = em.createNamedQuery("Metadonnee.findAll", Metadonnee.class).getResultList();

        } catch (Exception e) {
        }
        return liste;
    }

    public Metadonnee selectImageById(Integer id) {
       // Metadonnee meta = em.createNamedQuery("Metadonnee.findByIdMetadata", Metadonnee.class).setParameter("idMetadata", id).getSingleResult();
        return em.createNamedQuery("Metadonnee.findByIdMetadata", Metadonnee.class).setParameter("idMetadata", id).getSingleResult();
    }

    public List<Metadonnee> selectAllPartage() {
        List<Metadonnee> liste = new ArrayList<>();
        try {
            liste = em.createNamedQuery("Metadonnee.findByPartage", Metadonnee.class).setParameter("partage", true).getResultList();

        } catch (Exception e) {
        }
        return liste;
    }

    public boolean createControl(String username, String password, String nom, String prenom) {

        try {

            Login nouveau = new Login(username, password, nom, prenom);
            em.persist(nouveau);
            em.flush();
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public boolean metadataControl(Metadonnee metadonnee) {
        em.persist(metadonnee);
        em.flush();
        em.getTransaction().commit();
        return true;
    }

    public List<Metadonnee> selectImagesControl(String username) {

        List<Metadonnee> liste = new ArrayList<Metadonnee>();

        liste = em.createNamedQuery("Metadonnee.findByUserName", Metadonnee.class).setParameter("userName", username).getResultList();
        return liste;
    }

    public void deleteImageById(Integer Id) {
        EntityTransaction etx = em.getTransaction();
        if (!etx.isActive())etx.begin();
        Metadonnee meta = em.createNamedQuery("Metadonnee.findByIdMetadata", Metadonnee.class).setParameter("idMetadata",Id).getSingleResult();
        em.remove(meta);
        em.flush();
        etx.commit();
    }


    public void changeDescription(Metadonnee meta) {
        EntityTransaction etx = em.getTransaction();
        if (!etx.isActive())etx.begin();
        em.merge(meta);
        em.flush();
        etx.commit();
    }
    
    public void partager(Metadonnee meta){
        EntityTransaction etx = em.getTransaction();
        if (!etx.isActive())etx.begin();
        em.merge(meta);
        em.flush();
        etx.commit();
    }

}
