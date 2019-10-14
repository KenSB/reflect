package Reflect.States;

import Reflect.Entities.Entity;
import Reflect.Entities.Player;
import Reflect.Entities.Wall;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;


public class Level extends State{
    final int dimension = 50;
    final int gridX = 10;
    final int gridY = 25;
    private Player player;

    public Level(String name, String file) throws IOException {
        super(name);
        BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
        String currentLine;
        char currentChar;
        int y = 0;
        Entity store;
        while ((currentLine = reader.readLine()) != null) {
            for(int x = 0; x < gridX; x++) {
                currentChar = currentLine.charAt(x);
                if (currentChar != '0'){
                    store = createEntity(currentChar, x, y);
                    entities.add(store);
                    if (currentChar == 'P'){
                        player = (Player)store;
                    }
                }
            }
            y++;
        }
    }

    private Entity createEntity(char entity, int x, int y){
        switch (entity) {
            case 'P':
                return new Player(x, y, this);
            case 'W':
                return new Wall(x, y, this);
        }
        return null;
    }

    @Override
    public void keyPressed(int key) {
        System.out.println(player.getXPos()+" "+player.getYPos());
        switch(key){
            case KeyEvent.VK_W:
                player.move(1);
                break;
            case KeyEvent.VK_A:
                player.move(4);
                break;
            case KeyEvent.VK_S:
                player.move(2);
                break;
            case KeyEvent.VK_D:
                player.move(3);
                break;
        }
    }
    @Override
    public void draw(Graphics g) {
        for(Entity entity : entities){
            entity.draw(g);
        }
    }
}
