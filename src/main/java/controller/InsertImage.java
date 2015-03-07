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
import java.sql.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    
    public String message() throws IOException, IOException,SAXException, TikaException{
        

        //création d'un dossier
          File folder = new File("C:\\Users\\admin\\Desktop\\Login Example\\Login Example\\web\\resources\\images");
          String filename = FilenameUtils.getBaseName(file.getFileName()); 
          String extension = FilenameUtils.getExtension(file.getFileName());
          File destFile = File.createTempFile(filename + "-", "." + extension);
          FileUtils.copyInputStreamToFile(file.getInputstream(), destFile);
          FileUtils.copyFileToDirectory(destFile, folder);
         
          // ici, nous allons récupérer les métadonnées.
          File folder2 = new File("C:\\Users\\admin\\Desktop\\Login Example\\Login Example\\web\\resources\\metadata");
          BodyContentHandler handler = new BodyContentHandler();
          Metadata metadata = new Metadata();
          
          FileInputStream inputstream = new FileInputStream(destFile);
          ParseContext pcontext = new ParseContext();
          //Jpeg Parse 
          JpegParser  JpegParser = new JpegParser();
          
          JpegParser.parse(inputstream, handler, metadata,pcontext);
          
          System.out.println("***************************************************************************");
          System.out.println("Contents of the document:" + handler.toString());
          System.out.println("Metadata of the document:");
          String[] metadataNames = metadata.names();
          File metadataFile = File.createTempFile(filename + "-", "." + "txt");
  
          for(String name : metadataNames) { 		        
          System.out.println(name + ": " + metadata.get(name));
          FileUtils.writeStringToFile(metadataFile,name + ": " + metadata.get(name)+ "\n" , true);
            }
          FileUtils.copyFileToDirectory(metadataFile, folder2);
          
          Metadonnee m= new Metadonnee(filename, "MaDescription", Integer.parseInt(metadata.get(Metadata.ALTITUDE)), Integer.parseInt(metadata.get(Metadata.LONGITUDE)),metadata.get(Metadata.DATE) , metadata.get(Metadata.TOTAL_TIME), 10,destFile.getName());
            DataQuery query=new DataQuery();
            query.metadataControl(m);
          
          
           
//        Images imgs = new Images();
//        imgs.setIdImage((Integer)22);
//
//        
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        
//        byte[] buffer = new byte[16]; 
//        try {
//            while (file.getInputstream().read(buffer) != -1) out.write(buffer);
//        } catch (IOException ex) {
//            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        imgs.setContenu(out.toByteArray());
//        imgs.setContenu(null);
//        img.create(imgs);
//        img.create(imgs);
        return "hello all";
    }
}
