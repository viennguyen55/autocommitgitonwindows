/*
 * 
 */
package autocommitgit;

import java.net.InetAddress;
import java.net.ServerSocket;

import autocommitgit.layout.CongfigAppUI;
import autocommitgit.other.OS;
import autocommitgit.layout.TrayUI;
import autocommitgit.other.Message;

/**
 * Auto commit git when response has any change.
 * support Windows OS
 * @author hoaiv
 * version 1.0
 */
public class AutoCommitGit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	// single app run on OS
    	Boolean singleApp =  false;
    	try{
    	    ServerSocket socket = 
    	        new ServerSocket(9999, 10, InetAddress.getLocalHost());

    	}catch(java.net.BindException b){
    		singleApp =  true;
    	    System.out.println("Already Running...");
    	}catch(Exception e){
    	    System.out.println(e.toString());
    	}
    	
        if (new OS().isSupport() && !singleApp) {
        	
            if (GitCommand.isGit()) {
                TrayUI tray = null;
                ThreadWait wait = new ThreadWait();
                CongfigAppUI config =  new CongfigAppUI(wait, tray);
                config.setLocationRelativeTo(null);
                config.setVisible(true);
                tray = new TrayUI(wait, config);
                
            } else {
                new Message().showMessage("You do not set enviroment for command line. "
                        + "Please setup then you can run program. Thanks");
            }
        } else {
        	String message  = "";
        	if( singleApp ){
        		message = "App is running.";
        	}else
        		message = " Your OS is not support on my program. "
                        + "I'm sorry. I hope I can support your os soon. Thanks.";
            new Message().showMessage(message);
        }
    }

}
