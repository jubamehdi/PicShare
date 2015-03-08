package controller;

import entity.Metadonnee;
import query.DataQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author admin
 */
@ManagedBean(name = "selectImages")
@SessionScoped
public class SelectImagesController implements Serializable{
    private String username;
    private List<Metadonnee> listMeta;
    private DataQuery query= new DataQuery();

    public void SelectImagesController() {
    List<Metadonnee> liste = new ArrayList<Metadonnee>();
    listMeta=query.selectImagesControl(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Metadonnee> getListMeta() {
        return listMeta;
    }

    public void setListMeta(List<Metadonnee> listMeta) {
        this.listMeta = listMeta;
    }
    
}