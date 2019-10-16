package Reflect;

import javax.swing.*;

public class AnimationTimer extends Thread {
    JPanel frame;
    AnimationTimer(JPanel frame){
        this.frame = frame;
    }

    public void run() {
        while(true) {
            try {
                System.out.println("oee");
                frame.repaint();
                sleep(50);
            } catch (Exception e) {
            }
        }
    }
}
