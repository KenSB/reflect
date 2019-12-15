package Escape.Entities;

import javax.swing.*;

public class EntityAnimationTimer extends Thread{
    private Entity entity;
    JPanel frame;
    private int segment = 1;

    EntityAnimationTimer(Entity entity, JPanel frame){
        super();
        this.entity = entity;
        this.frame = frame;
    }
    public void run() {
        while (true) {
            try {
                if (entity.animate) {
                    if (segment <= entity.movingDistance * 5) {
                        if (entity.movingDirection == entity.RIGHT) {
                            entity.xDraw = entity.xGrid * entity.dimension + 10 * segment;
                            entity.yDraw = entity.yGrid * entity.dimension;
                        } else if (entity.movingDirection == entity.LEFT) {
                            entity.xDraw = entity.xGrid * entity.dimension - 10 * segment;
                            entity.yDraw = entity.yGrid * entity.dimension;
                        } else if (entity.movingDirection == entity.DOWN) {
                            entity.xDraw = entity.xGrid * entity.dimension;
                            entity.yDraw = entity.yGrid * entity.dimension + 10 * segment;
                        } else if (entity.movingDirection == entity.UP) {
                            entity.xDraw = entity.xGrid * entity.dimension;
                            entity.yDraw = entity.yGrid * entity.dimension - 10 * segment;
                        }
                    } else {
                        entity.animate = false;
                        segment = 1;
                        entity.changePos(entity.movingDirection, entity.movingDistance);
                        entity.level.update();
                    }
                    segment++;
                    frame.repaint();
                }
                sleep(15);
            } catch (InterruptedException e) {
                System.out.println("Exception is caught");
            }
        }
    }
}
