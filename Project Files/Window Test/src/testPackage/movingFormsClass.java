/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPackage;

import javax.swing.JLabel;

/**
 *
 * @author Phil Rey Paderogao
 */
public class movingFormsClass {
    private int start,stop,delay,increment,direction;
    private JLabel label;
    

    public movingFormsClass(int start, int stop, int delay, int increment, JLabel label,int direction) {
        this.start = start;
        this.stop = stop;
        this.delay = delay;
        this.increment = increment;
        this.label = label;
        this.direction = direction;
    }
    
    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }

    public int getDelay() {
        return delay;
    }

    public int getIncrement() {
        return increment;
    }

    public JLabel getLabel() {
        return label;
    }

    public int getDirection() {
        return direction;
    }
    
    
}
