package Reflect;

import Reflect.States.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Frame extends JPanel implements ActionListener, KeyListener, MouseListener {
    State currentState = new Level("Reflect/level1","C:\\Users\\KenSB\\IdeaProjects\\reflect\\Base\\src\\Reflect\\level1", this);
    public Frame() throws IOException {
        setPreferredSize(new Dimension(1900,1280));
        setBackground(Color.BLACK);
        addKeyListener(this);
        addMouseListener(this);
        this.setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        currentState.draw(g);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {}
    @Override
    public void keyTyped(KeyEvent keyEvent) {}
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        currentState.keyPressed(keyCode);
//        repaint();
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
