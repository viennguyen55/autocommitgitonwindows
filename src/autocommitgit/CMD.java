/*
 * Run command in CMD and get rusult
 */
package autocommitgit;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * run comman line on window
 * @author hoaiv
 */
public class CMD {
 /**
  * run command with current folder
  * @param cmd
  * @return 
  */ 
 public String execCMD(String cmd){
     String result = "";
     try {
         Process process = Runtime.getRuntime().exec(cmd);
         DataInputStream out = new DataInputStream(process.getInputStream());
         String line = "";
         result = out.readLine();
         while( ( line = out.readLine()) != null ){
             result += line;
         }
     } catch (IOException ex) {
         Logger.getLogger(CMD.class.getName()).log(Level.SEVERE, null, ex);
     }
     return result;
 }
 /**
  * run command with folderPath
  * @param cmd
  * @param folderPath
  * @return 
  */
 public String execCMD(String cmd, String folderPath ){
     String result = "";
     try {
         Process process = Runtime.getRuntime().exec(cmd, null, new File( folderPath ) );
         DataInputStream out = new DataInputStream(process.getInputStream());
         String line = "";
         result = out.readLine();
         while( ( line = out.readLine()) != null ){
             result += line;
         }
     } catch (IOException ex) {
         Logger.getLogger(CMD.class.getName()).log(Level.SEVERE, null, ex);
     }
     return result;
 }
}
