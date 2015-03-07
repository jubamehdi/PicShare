/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "metadata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metadonnee.findAll", query = "SELECT m FROM Metadonnee m"),
    @NamedQuery(name = "Metadonnee.findByIdMetadata", query = "SELECT m FROM Metadonnee m WHERE m.idMetadata = :idMetadata"),
    @NamedQuery(name = "Metadonnee.findByTitreImage", query = "SELECT m FROM Metadonnee m WHERE m.titreImage = :titreImage"),
    @NamedQuery(name = "Metadonnee.findByDesignation", query = "SELECT m FROM Metadonnee m WHERE m.designation = :designation"),
    @NamedQuery(name = "Metadonnee.findByImageHeight", query = "SELECT m FROM Metadonnee m WHERE m.imageHeight = :imageHeight"),
    @NamedQuery(name = "Metadonnee.findByImageWidth", query = "SELECT m FROM Metadonnee m WHERE m.imageWidth = :imageWidth"),
    @NamedQuery(name = "Metadonnee.findByDateCreation", query = "SELECT m FROM Metadonnee m WHERE m.dateCreation = :dateCreation"),
    @NamedQuery(name = "Metadonnee.findByTimeCreation", query = "SELECT m FROM Metadonnee m WHERE m.timeCreation = :timeCreation"),
    @NamedQuery(name = "Metadonnee.findByIdUser", query = "SELECT m FROM Metadonnee m WHERE m.idUser = :idUser")})
public class Metadonnee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_METADATA")
    private Integer idMetadata;
    @Size(max = 45)
    @Column(name = "TITRE_IMAGE")
    private String titreImage;
    @Size(max = 45)
    @Column(name = "DESIGNATION")
    private String designation;
    @Column(name = "IMAGE_HEIGHT")
    private Integer imageHeight;
    @Column(name = "IMAGE_WIDTH")
    private Integer imageWidth;
    @Size(max = 50)
    @Column(name = "DATE_CREATION")
    private String dateCreation;
    @Size(max = 50)
    @Column(name = "TIME_CREATION")
    private String timeCreation;
    @Column(name = "ID_USER")
    private Integer idUser;
    @Column(name = "LIEN")
    private String lien;
    
    public Metadonnee() {
    }

    public Metadonnee(String titreImage, String designation, Integer imageHeight, Integer imageWidth, String dateCreation, String timeCreation, Integer idUser, String lien) {
        this.titreImage = titreImage;
        this.designation = designation;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
        this.dateCreation = dateCreation;
        this.timeCreation = timeCreation;
        this.idUser = idUser;
        this.lien = lien;
    }

    
    
    public Metadonnee(Integer idMetadata) {
        this.idMetadata = idMetadata;
    }

    public Integer getIdMetadata() {
        return idMetadata;
    }

    public void setIdMetadata(Integer idMetadata) {
        this.idMetadata = idMetadata;
    }

    public String getTitreImage() {
        return titreImage;
    }

    public void setTitreImage(String titreImage) {
        this.titreImage = titreImage;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(String timeCreation) {
        this.timeCreation = timeCreation;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMetadata != null ? idMetadata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metadonnee)) {
            return false;
        }
        Metadonnee other = (Metadonnee) object;
        if ((this.idMetadata == null && other.idMetadata != null) || (this.idMetadata != null && !this.idMetadata.equals(other.idMetadata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Metadonnee[ idMetadata=" + idMetadata + " ]";
    }
    
}
