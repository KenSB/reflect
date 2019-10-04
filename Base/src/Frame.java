import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JPanel implements ActionListener, KeyListener, MouseListener {

    public Frame(){
        setPreferredSize(new Dimension(1920,1280));
        setBackground(Color.BLACK);
        addKeyListener(this);
        addMouseListener(this);
        this.setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fill3DRect(0,0,50,50,true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {}
    @Override
    public void keyTyped(KeyEvent keyEvent) {}
    @Override
    public void keyPressed(KeyEvent keyEvent) {}
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
