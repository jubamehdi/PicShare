/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import query.DataQuery;

import org.primefaces.context.RequestContext;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/**
 *
 * @author User
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable  {

    private String username;
    private String password;
    private DataQuery query = new DataQuery();

    public String loginControl() {
        if (query.loginControl(username, password)) {
            //creéation de la session
            ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("username", username);
            SelectImagesController s= new SelectImagesController();
            s.setUsername(username);
            s.SelectImagesController();
            return "recupimages.xhtml?faces-redirect=true";
        }
        RequestContext.getCurrentInstance().update("grow1");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Username or Password invalid!!!"));
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

}
