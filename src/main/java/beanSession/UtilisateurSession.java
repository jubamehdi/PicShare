/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author juba
 */
@ManagedBean
@SessionScoped
public class UtilisateurSession implements Serializable{
    
    private String pseudo;
    private String mdp;
    
    private boolean estConnecte= false;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean isEstConnecte() {
        return estConnecte;
    }

    public void setEstConnecte(boolean estConnecte) {
        this.estConnecte = estConnecte;
    }
    
    public String connexion(){
        if(this.pseudo.equals("youba@gmail.com") && this.mdp.equals("mdp")){
            estConnecte = true;
            return "compteUtilisateur.xhtml"; 
        }
        return "index.xhtml";
    }
    
    /**
     * Creates a new instance of UtilisateurSession
     */
    public UtilisateurSession() {
    }
    
}
