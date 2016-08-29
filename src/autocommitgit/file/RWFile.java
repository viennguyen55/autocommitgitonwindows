/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocommitgit.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author hoaiv
 */
public class RWFile {
    private final String PATH = System.getProperty("user.dir") + "\\config.txt";
    private final String DEFAULT_PATH = "C:\\";
    public RWFile(){
        File file =  new File(PATH);
        if(!file.exists()){
            try {
                Path pathToFile = Paths.get(PATH);
                Files.createFile(pathToFile);
                writeFile(DEFAULT_PATH);
            } catch (IOException ex) {
                Logger.getLogger(RWFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void writeFile(String path){
         DataOutputStream out = null;
        try {
            out =  new DataOutputStream(new FileOutputStream(PATH));
             try {
                 out.writeBytes(path);
             } catch (IOException ex) {
                 Logger.getLogger(RWFile.class.getName()).log(Level.SEVERE, null, ex);
             }
             try {
                 out.close();
             } catch (IOException ex) {
                 Logger.getLogger(RWFile.class.getName()).log(Level.SEVERE, null, ex);
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RWFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String readFile(){
        String path = "";
        try {
            DataInputStream in =  new DataInputStream(new FileInputStream(PATH));
            try {
                path = in.readLine();
            } catch (IOException ex) {
                Logger.getLogger(RWFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(RWFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RWFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        if( path.length() == 0 ){
            writeFile(DEFAULT_PATH);
            return DEFAULT_PATH;
        }
        return path;
    }
    
}
