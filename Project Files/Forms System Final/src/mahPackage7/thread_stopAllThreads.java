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
            for(int n=0;n<10;n++){
                my.interrupMainThread();
                my.interrupSecondThread();
                my.interruptThirdThread();
                System.out.println("Stopping Threads "+(n+1));
                Thread.sleep(100);
            }
            
            if(!myFunctions.getMainThead().isAlive() && !myFunctions.getSecondThread().isAlive() && !myFunctions.getThirdThread().isAlive()){
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
