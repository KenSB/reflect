package Reflect;

import Reflect.Entities.Player;
import Reflect.States.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JPanel implements ActionListener, KeyListener, MouseListener {
    State currentState = new Level("Test");
    public Frame(){
        setPreferredSize(new Dimension(1920,1280));
        setBackground(Color.BLACK);
        addKeyListener(this);
        addMouseListener(this);
        this.setFocusable(true);
        ((Level)currentState).addEntity(new Player(50,50));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fill3DRect(0,0,50,50,true);
        currentState.draw(g);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {}
    @Override
    public void keyTyped(KeyEvent keyEvent) {}
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        switch(keyCode){
            case KeyEvent.VK_W:


        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {}
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}
    @Override
    public void mousePressed(MouseEvent mouseEvent) {}
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}
    @Override
    public void mouseExited(MouseEvent mouseEvent) {}
}
