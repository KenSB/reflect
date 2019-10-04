import Entities.Entity;

import java.util.ArrayList;

public class Level {
    private int [][] grid = new int[500][500];
    private ArrayList<Entity> entities = new ArrayList<>();
    private String name;
    public Level(String name){
        this.name = name;
    }
}
