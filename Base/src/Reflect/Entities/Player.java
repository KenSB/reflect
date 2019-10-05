package Reflect.Entities;

import java.awt.*;

public class Player extends Entity implements Animatable{
    private int direction = 0;
    public Player(int xPos, int yPos) {
        super(xPos, yPos);
    }

    @Override
    public void collision() {}
    @Override
    public void move() {
        if(direction != 0){
            changePos();
        }
    }

    private void changePos(){
        if(direction == UP)
            yPos -= 1;
        else if(direction == DOWN)
            yPos += 1;
        else if(direction == RIGHT)
            xPos += 1;
        else if(direction == LEFT)
            xPos -= 1;
    }
    @Override
    public void animate() {
    }
    @Override
    public void draw(Graphics g) {
        g.draw3DRect(xPos, yPos, 50, 50, true);
    }
}
