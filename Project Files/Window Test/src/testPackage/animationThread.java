/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPackage;

import AppPackage.AnimationClass;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author Phil Rey Paderogao
 */
public class animationThread extends SwingWorker<String, String>{
    private AnimationClass animate;
    private movingFormsClass anims [];
    private long animationsDelay;
    public animationThread(movingFormsClass [] animations,long animationsDelay) {
        animate = new AnimationClass();
        anims = animations;
        this.animationsDelay = animationsDelay;
    }
    
    
    
    @Override
    protected String doInBackground() throws Exception {
        for(int n=0;n<anims.length;n++){
            switch(anims[n].getDirection()){
                case 1:{    //Up
                    animate.jLabelYUp(anims[n].getStart(), anims[n].getStop(), anims[n].getDelay(), anims[n].getIncrement(), anims[n].getLabel());
                    break;
                }case 2:{   //Down
                    animate.jLabelYDown(anims[n].getStart(), anims[n].getStop(), anims[n].getDelay(), anims[n].getIncrement(), anims[n].getLabel());
                    break;
                }case 3:{   //Left
                    animate.jLabelXLeft(anims[n].getStart(), anims[n].getStop(), anims[n].getDelay(), anims[n].getIncrement(), anims[n].getLabel());
                    break;
                }case 4:{   //Right
                    animate.jLabelXRight(anims[n].getStart(), anims[n].getStop(), anims[n].getDelay(), anims[n].getIncrement(), anims[n].getLabel());
                    break;
                }
            }
            Thread.sleep(animationsDelay + (animationsDelay * n));
        }
        Thread.sleep(animationsDelay);
        setProgress(100);
        
        return null;
    }

    @Override
    protected void done() {
        System.out.println("Task Completed");
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
