/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Metadonnee;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import query.DataQuery;

/**
 *
 * @author juba
 */

@ManagedBean(name = "manipImage")
@SessionScoped
public class gestionImageController implements Serializable{
    DataQuery query = new DataQuery();
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public gestionImageController() {
    }
    
    public String modifieDescriptionImage(String ids){
        System.err.println("__________________________valeur idS : "+ids);
        Integer id = Integer.parseInt(ids);
        Metadonnee m= query.selectImageById((Integer)23);
        m.setDesignation(description);
        query.changeDescription(m);
        return"images.xhtml?faces-redirect=true";
    }
    
    public void deleteImage(Integer id){
      query.deleteImageById(id);              
    }
    
}
