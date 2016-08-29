/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocommitgit.layout;

import autocommitgit.ThreadWait;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

/**
 * run below trayicon
 * @author hoaiv
 */
public class TrayUI {
    private TrayIcon trayicon;
    private PopupMenu pop ;
    public TrayUI( ThreadWait wait, CongfigAppUI config){
        pop =  new Popup( wait, config ).getPop();
        String pathImage = System.getProperty("user.dir") + "\\images\\icon.png";
//        System.out.println(pathImage);
        Image image = Toolkit.getDefaultToolkit().getImage(pathImage);
        
        trayicon = new TrayIcon(image, "Auto comit git.");
        trayicon.setPopupMenu(pop);
        SystemTray trays = SystemTray.getSystemTray();
        try {
                trays.add(trayicon);
        } catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
}
