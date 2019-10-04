package Entities;

public abstract class Entity{
    public int xPos;
    public int yPos;
    public Entity(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public abstract void collision();
    public abstract void move();
}
