package controller;

import entity.Metadonnee;
import query.DataQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author admin
 */
@ManagedBean(name = "selectImages")
@SessionScoped
public class SelectImagesController implements Serializable {

   // private String username;
 
    private List<Metadonnee> listMeta;
    private int size;
    private DataQuery query = new DataQuery();

    public SelectImagesController() {
    }
    
    public List<Metadonnee> getSelectImagesController(String username) {      
        listMeta = query.selectImagesControl(username);
        return listMeta;
    }
    
    public List<Metadonnee> getSelectAllImagesController() {
        listMeta = query.selectAll();
        return listMeta;
    }
    
    public List<Metadonnee> getSelectAllPartageImagesController() {
        listMeta = query.selectAllPartage();
        return listMeta;
    }

    public Metadonnee selectImagesByIDController(String idS) {
        Integer id=Integer.parseInt(idS);
        System.err.println("id ___________________ : "+idS);
        Metadonnee meta = query.selectImageById(id);
        return meta;
    }
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    public List<Metadonnee> getListMeta() {
        return listMeta;
    }

    public void setListMeta(List<Metadonnee> listMeta) {
        this.listMeta = listMeta;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
}
