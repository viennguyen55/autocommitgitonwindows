/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocommitgit.layout;

import autocommitgit.other.Author;
import autocommitgit.CMD;
import autocommitgit.Config;
import autocommitgit.GitCommand;
import autocommitgit.ThreadWait;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import autocommitgit.other.MessageComit;
import autocommitgit.other.Message;

/**
 *
 * @author hoaiv
 */
public class Popup {
    private PopupMenu popup ;
    private CongfigAppUI config;
    private ThreadWait wait;
    private MenuItem pauseItem = new MenuItem("Pause");
    
    public Popup( ThreadWait wait, CongfigAppUI config){
        popup =  new PopupMenu();
        this.config = config;
        this.wait = wait;
        
        MenuItem aboutItem = new MenuItem("About");
        MenuItem configItem = new MenuItem("Configuration");
        MenuItem cmdItem = new MenuItem("Open cmd");
        MenuItem commitItem = new MenuItem("Commit");
        MenuItem exitItem = new MenuItem("Exit");
        //Add components to pop-up menu
        popup.add(configItem);
        popup.add(pauseItem);
        popup.add(cmdItem);
        popup.add(commitItem);
        popup.addSeparator();
        popup.add(aboutItem);
        popup.add(exitItem);
        
        addEvents(aboutItem, configItem, exitItem, pauseItem, commitItem, cmdItem);
    }
    private void addEvents(MenuItem about, MenuItem configItem, MenuItem exit,
                            MenuItem pause, MenuItem commitItem, MenuItem cmdItem){
        about.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Author().showAuthorInfo();
            }
        });
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        configItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                config.setVisible(true);
                config.setLocationRelativeTo(null);
                config.setPath(Config.path);
            }
        });
        cmdItem.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new CMD().execCMD("cmd.exe /c start");
            }
        });
        commitItem.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String status = GitCommand.status(Config.path);
                
                if( status != null ){
                    String mess = new  MessageComit().ask();
                    if( mess != null ){
                    	GitCommand.commit(mess, Config.path);
                    }else{
                        new Message().showMessage("Destroy commit.");
                    }
                }else{
                    new Message().showMessage("Nothing to commit.");
                }
            }
        });
        pause.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                wait.toggle();
                toggleName();
            }
        });
    }
    private void toggleName(){
        if( pauseItem.getLabel().contains("Pause") ){
            pauseItem.setLabel("Start");
        }else
            pauseItem.setLabel("Pause");
    }
    public PopupMenu getPop(){
        return popup;
    }
}
