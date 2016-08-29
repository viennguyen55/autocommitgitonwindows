/*
 * Loop to check change
 */
package autocommitgit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import autocommitgit.other.MessageComit;
import autocommitgit.other.Message;

/**
 *
 * @author hoaiv
 */
public class ThreadWait {
    Timer timer;
    
    public ThreadWait(){
        timer =  new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String isChange =  GitCommand.status(Config.path);
                if( isChange == null ){
                    System.out.println("no change" + Math.random());
                }else{
                    System.out.println("change"  + Math.random());
                }
                if( (isChange != null) && (Config.isAsk) ){
//                    timer.stop();
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
//                    timer.start();
                }else if( (isChange != null) && !Config.isAsk ){
//                    timer.stop();
                    String status = GitCommand.status(Config.path);
                
                    if( status != null ){
                        
                        String mess = new MessageComit().makeComit(Config.path);
                        GitCommand.commit(mess, Config.path);
                      
                    }else{
                        new Message().showMessage("Nothing to commit.");
                    }
//                    timer.start();
                }
            }
        });
    }
    public void stop(){
        timer.stop();
    }
    public void start(){
        timer.start();
    }
    public Boolean isRun(){
        return timer.isRunning();
    }
    public void toggle(){
        if( timer.isRunning() ){
            timer.stop();
        }else{
            timer.start();
        }
    }
}
