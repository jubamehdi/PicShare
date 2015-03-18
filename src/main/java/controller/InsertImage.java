/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Metadonnee;
import query.DataQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.jpeg.JpegParser;
import org.apache.tika.sax.BodyContentHandler;
import org.primefaces.model.UploadedFile;
import org.xml.sax.SAXException;

/**
 *
 * @author admin
 */
@ManagedBean(name = "insert")
@SessionScoped
public class InsertImage {

    private UploadedFile file;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    /**
     * Creates a new instance of Index
     */
    public InsertImage() {
    }

    public String message() throws IOException, IOException, SAXException, TikaException {

        //création d'un dossier
        File folder = new File("C:\\Users\\juba\\Documents\\NetBeansProjects\\Pic_Share\\src\\main\\webapp\\resources\\images");
        String filename = FilenameUtils.getBaseName(file.getFileName());
        String extension = FilenameUtils.getExtension(file.getFileName());

        File destFile = File.createTempFile(filename, "." + extension);
        FileUtils.copyInputStreamToFile(file.getInputstream(), destFile);
        FileUtils.copyFileToDirectory(destFile, folder);

        // ici, nous allons récupérer les métadonnées.
        File folder2 = new File("C:\\Users\\juba\\Documents\\NetBeansProjects\\Pic_Share\\src\\main\\webapp\\resources\\metadata");
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();

        FileInputStream inputstream = new FileInputStream(destFile);
        ParseContext pcontext = new ParseContext();
        //Jpeg Parse 
        JpegParser JpegParser = new JpegParser();

        JpegParser.parse(inputstream, handler, metadata, pcontext);

        System.out.println("***************************************************************************");
        System.out.println("Contents of the document:" + handler.toString());
        System.out.println("Metadata of the document:");
        String[] metadataNames = metadata.names();
        File metadataFile = File.createTempFile(filename + "-", "." + "txt");

        for (String name : metadataNames) {
            System.out.println(name + ": " + metadata.get(name));
            FileUtils.writeStringToFile(metadataFile, name + ": " + metadata.get(name) + "\n", true);
        }
        FileUtils.copyFileToDirectory(metadataFile, folder2);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String sDate = dateFormat.format(date);
        DateFormat heure = new SimpleDateFormat("HH:mm:ss");
        Date date2 = new Date();
        String hDate = heure.format(date2);
        //(Integer.parseInt(metadata.get(Metadata.ALTITUDE)))   Integer.parseInt(metadata.get(Metadata.ALTITUDE))     
        Metadonnee m = new Metadonnee(filename, description,metadata.get("Image Width"),
               metadata.get("Image Height"), sDate, hDate, (String) ((HttpSession) (FacesContext.getCurrentInstance().getExternalContext().getSession(false))).getAttribute("username"), 
            destFile.getName(), Boolean.FALSE);

        DataQuery query = new DataQuery();
        query.metadataControl(m);

        return "hello all";
    }
}
