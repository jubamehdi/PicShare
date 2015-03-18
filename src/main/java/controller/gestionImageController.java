/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Metadonnee;
import java.io.Serializable;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import query.DataQuery;

/**
 *
 * @author juba
 */
@ManagedBean(name = "manipImage")
@SessionScoped
public class gestionImageController implements Serializable {

    DataQuery query = new DataQuery();
    private String description = "testettt";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public gestionImageController() {
    }

    public String modifieDescriptionImage() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer id = Integer.parseInt(params.get("idImage"));
        Metadonnee m = query.selectImageById(id);
        m.setDesignation(description);
        query.changeDescription(m);
        return "images.xhtml?faces-redirect=true";
    }

    public void deleteImage() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer id = Integer.parseInt(params.get("idImage"));
        query.deleteImageById(id);
    }

    public String partagerImage() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer id = Integer.parseInt(params.get("idImage"));
        Metadonnee m = query.selectImageById(id);
        m.setPartage(!m.getPartage());
        query.partager(m);
        return "images.xhtml?faces-redirect=true";
    }
}
