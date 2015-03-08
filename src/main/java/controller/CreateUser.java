/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import query.DataQuery;
import java.time.Clock;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author admin
 */
@ManagedBean(name = "create")
@RequestScoped
public class CreateUser implements Serializable {

    private String username;
    private String password;
    private String nom;
    private String prenom;
    private DataQuery query = new DataQuery();

    public CreateUser() {
    }

    /**
     * Creates a new instance of LoginCreate
     *
     * @return
     */
    public String loginCreate() {

        if (query.createControl(username, password, nom, prenom)) {

            return "compteUtilisateur.xhtml?faces-redirect=true";
        }

//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "pseudoI", "Username already exists!!!"));
        FacesContext.getCurrentInstance().addMessage("pseudoC", new FacesMessage("un compte existe"));
        return "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
