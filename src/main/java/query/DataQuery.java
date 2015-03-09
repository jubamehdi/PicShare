/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import entity.Login;
import entity.Metadonnee;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
    
    public List<Metadonnee> selectAll() {
        List<Metadonnee> liste= new ArrayList<>();
        try {
            liste = em.createNamedQuery("Metadonnee.findAll", Metadonnee.class).getResultList();
            
        } catch (Exception e) {
        }
        return liste;
    }
    public Metadonnee selectImageById(Integer id){
        Metadonnee meta = em.createNamedQuery("Metadonnee.findByIdMetadata", Metadonnee.class).setParameter("idMetadata", id).getSingleResult();
        return meta;
    }
    
    public List<Metadonnee> selectAllPartage() {
        List<Metadonnee> liste= new ArrayList<>();
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
    
     public List<Metadonnee> selectImagesControl(String username){
         
        List<Metadonnee> liste = new ArrayList<Metadonnee>();
        Login l = em.createNamedQuery("Login.findByUsername", Login.class).setParameter("username", username).getSingleResult();
        Integer idUser=l.getId();
        liste = em.createNamedQuery("Metadonnee.findByIdUser", Metadonnee.class).setParameter("idUser", idUser).getResultList();
        for(Metadonnee m:liste){
            System.err.println("messssaaggggggeeee : "+ m.getLien());
        }
        return liste;
    }
     
}
