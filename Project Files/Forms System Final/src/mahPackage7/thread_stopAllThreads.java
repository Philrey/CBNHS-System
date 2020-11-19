/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;

import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class thread_stopAllThreads extends SwingWorker<String, Object>{
    myFunctions my;

    public thread_stopAllThreads() {
        my = new myFunctions(true);
    }
    
    
    @Override
    protected String doInBackground() throws Exception {
        boolean mainDone=false,secondDone=false,thirdDone=false;
        while (true) {
            if(myFunctions.getThirdThread() != null){
                if(!myFunctions.getThirdThread().isInterrupted() || myFunctions.getThirdThread().isAlive()){
                    my.interruptThirdThread();
                }else{
                    thirdDone = true;
                }
            }else{thirdDone = true;}
            
            if(myFunctions.getSecondThread() != null  || myFunctions.getSecondThread().isAlive()){
                if(!myFunctions.getSecondThread().isInterrupted()){
                    my.interrupSecondThread();
                }else{
                    secondDone = true;
                }
            }else{secondDone = true;}
            
            if(myFunctions.getMainThead() != null  || myFunctions.getMainThead().isAlive()){
                if(!myFunctions.getMainThead().isInterrupted()){
                    my.interrupMainThread();
                }else{
                    mainDone = true;
                }
            }else{mainDone = true;}
            
            if(mainDone && secondDone && thirdDone){
                break;
            }
        }
        return null;
    }

    @Override
    protected void done() {
        System.err.println("All Threads Stopped.");
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
