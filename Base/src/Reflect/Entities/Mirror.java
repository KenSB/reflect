package Reflect.Entities;

import Reflect.States.Level;

import java.awt.*;
import java.util.Optional;

public class Mirror extends Source{
    private int faceDirection = DOWNRIGHT;
    private int inDirection;
    private boolean isReflecting;
    public Mirror(int xGrid, int yGrid, Level level, int direction) {
        super(xGrid, yGrid, level, direction,true);
        isReflecting = false;
    }

    public void setIsReflecting(boolean isReflecting) {
        this.isReflecting = isReflecting;
    }

    public boolean checkHasLight(int inDirection){
        Optional<Entity> entity;
        if(inDirection == LEFT)
            entity = level.getEntity(xGrid - 1, yGrid);
        else if(inDirection == RIGHT)
            entity = level.getEntity(xGrid + 1,yGrid);
        else if(inDirection == UP)
            entity = level.getEntity(xGrid,yGrid - 1);
        else
            entity = level.getEntity(xGrid,yGrid + 1);
        System.out.println(entity == null);
        if(entity != null) {
            for(Light light: beam)
                if(light == entity.get())
                    return false;
            return entity.get() instanceof Light;
        }
        return false;
    }

    public boolean setReflecting(){
        inDirection = 0;
        if(faceDirection == UPRIGHT){
            if(checkHasLight(UP))
                inDirection = UP;
            else if(checkHasLight(RIGHT))
                inDirection = RIGHT;
        }
        else if(faceDirection == UPLEFT){
            if(checkHasLight(UP))
                inDirection = UP;
            else if(checkHasLight(LEFT))
                inDirection = LEFT;
        }
        else if(faceDirection == DOWNRIGHT){
            if(checkHasLight(DOWN))
                inDirection = DOWN;
            else if(checkHasLight(RIGHT))
                inDirection = RIGHT;
        }
        else if(faceDirection == DOWNLEFT){
            if(checkHasLight(DOWN))
                inDirection = DOWN;
            else if(checkHasLight(LEFT)) {
                inDirection = LEFT;
            }
        }
        if(inDirection != 0) {
            isReflecting = true;
            return true;
        }
        else{
            isReflecting = false;
            return false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.PINK);
        if(faceDirection == DOWNRIGHT) {
            g.fillPolygon(new int[]{xGrid * dimension, xGrid * dimension, (xGrid + 1) * dimension},
                    new int[]{yGrid * dimension, (yGrid + 1) * dimension, yGrid * dimension}, 3);
            if(isReflecting) {
                g.setColor(Color.WHITE);
                g.fillPolygon(new int[]{xGrid * dimension, (xGrid + 1) * dimension, (xGrid + 1) * dimension},
                        new int[]{(yGrid + 1) * dimension, yGrid * dimension, (yGrid + 1) * dimension}, 3);
            }
        }
        else if(faceDirection == UPRIGHT) {
            g.fillPolygon(new int[]{xGrid * dimension, xGrid * dimension, (xGrid + 1) * dimension},
                    new int[]{yGrid * dimension, (yGrid + 1) * dimension, (yGrid + 1) * dimension}, 3);
            if(isReflecting) {
                g.setColor(Color.WHITE);
                g.fillPolygon(new int[]{xGrid * dimension, (xGrid + 1) * dimension, (xGrid + 1) * dimension},
                        new int[]{yGrid * dimension, yGrid * dimension, (yGrid + 1) * dimension}, 3);
            }
        }
        else if(faceDirection == DOWNLEFT) {
            g.fillPolygon(new int[]{xGrid * dimension, (xGrid + 1) * dimension, (xGrid + 1) * dimension},
                    new int[]{yGrid * dimension, yGrid * dimension, (yGrid + 1) * dimension}, 3);
            if(isReflecting) {
                g.setColor(Color.WHITE);
                g.fillPolygon(new int[]{xGrid * dimension, xGrid * dimension, (xGrid + 1) * dimension},
                        new int[]{yGrid * dimension, (yGrid + 1) * dimension, (yGrid + 1) * dimension}, 3);
            }
        }
        else if(faceDirection == UPLEFT) {
            g.fillPolygon(new int[]{xGrid * dimension, (xGrid + 1) * dimension, (xGrid + 1) * dimension},
                    new int[]{(yGrid + 1) * dimension, yGrid * dimension, (yGrid + 1) * dimension}, 3);
            if(isReflecting) {
                g.setColor(Color.WHITE);
                g.fillPolygon(new int[]{xGrid * dimension, xGrid * dimension, (xGrid + 1) * dimension},
                        new int[]{yGrid * dimension, (yGrid + 1) * dimension, yGrid * dimension}, 3);
            }
        }
    }

    public boolean mirrorShine(int inDirection){
        return reflect(inDirection);
    }

    @Override
    public void interact() {
        turnOff();
        if(faceDirection == UPLEFT)
            faceDirection = UPRIGHT;
        else if(faceDirection == UPRIGHT)
            faceDirection = DOWNRIGHT;
        else if(faceDirection == DOWNRIGHT)
            faceDirection = DOWNLEFT;
        else if(faceDirection == DOWNLEFT)
            faceDirection = UPLEFT;
        if(setReflecting()) {
            isReflecting = true;
            reflect(inDirection);
        }
        else {
            isReflecting = false;
            setStatus(false);
        }
    }

    @Override
    public void update(){
        if(isReflecting) {
            turnOff();
            mirrorShine(inDirection);
        }
    }

    boolean reflect(int directIn){
        if(directIn == LEFT){
            if(faceDirection == UPLEFT){
                isReflecting = true;
                inDirection = LEFT;
                setDirection(UP);
                setStatus(true);
                return true;
            }
            else if(faceDirection == DOWNLEFT){
                isReflecting = true;
                inDirection = LEFT;
                setDirection(DOWN);
                setStatus(true);
                return true;
            }
        }
        else if(directIn == RIGHT){
            if(faceDirection == UPRIGHT){
                isReflecting = true;
                inDirection = RIGHT;
                setDirection(UP);
                setStatus(true);
                return true;
            }
            else if(faceDirection == DOWNRIGHT){
                isReflecting = true;
                inDirection = RIGHT;
                setDirection(DOWN);
                setStatus(true);
                return true;
            }
        }
        else if(directIn == DOWN){
            if(faceDirection == DOWNRIGHT){
                isReflecting = true;
                inDirection = DOWN;
                setDirection(RIGHT);
                setStatus(true);
                return true;
            }
            else if(faceDirection == DOWNLEFT){
                isReflecting = true;
                inDirection = DOWN;
                setDirection(LEFT);
                setStatus(true);
                return true;
            }
        }
        else if(directIn == UP){
            if(faceDirection == UPRIGHT){
                isReflecting = true;
                inDirection = UP;
                setDirection(RIGHT);
                setStatus(true);
                return true;
            }
            else if(faceDirection == UPLEFT){
                isReflecting = true;
                inDirection = UP;
                setDirection(LEFT);
                setStatus(true);
                return true;
            }
        }
        return false;
    }
}
