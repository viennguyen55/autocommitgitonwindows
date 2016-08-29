/*
 * create message for commit 
 */
package autocommitgit.other;

import autocommitgit.GitCommand;
import javax.swing.JOptionPane;

/**
 *
 * @author hoaiv
 */
public class MessageComit {
    public String ask(){
        String mess = JOptionPane.showInputDialog(null,  "What's your message commit?");
        while( mess != null  && mess.length() == 0 ){
            mess = JOptionPane.showInputDialog(null,  "PLEASE!!!!!!!!!!!\nWhat's your message commit?");
        }
        return mess;
    }
    public String makeComit( String folder ){
        String result =  GitCommand.status(folder);
        String message = "";
        if( result != null ){
             message =  result.substring(result.indexOf("unstage)") + 8);
        }else{
            message = null;
        }
        return message;
    }
}
