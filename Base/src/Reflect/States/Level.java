package Reflect.States;

import Reflect.Entities.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;


public class Level extends State{
    final int dimension = 50;
    final int gridX = 38;
    final int gridY = 25;
    private Player player;
    private ArrayList<Entity> animated = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Entity> spawn = new ArrayList<>();
    private ArrayList<Entity> remove = new ArrayList<>();

    boolean updating;



    public Level(String name, String file, JPanel frame) throws IOException {
        super(name, frame);
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
            case 'S':
                return new Source(x, y, this, 3, false);
            case 'M':
                return new Mirror(x,y,this,0);
        }
        return null;
    }

    @Override
    public void keyPressed(int key) {
        System.out.println(player.getXPos()+" "+player.getYPos());
        if(!updating) {
            switch (key) {
                case KeyEvent.VK_W:
                    player.move(1, 1);
                    break;
                case KeyEvent.VK_A:
                    player.move(4, 1);
                    break;
                case KeyEvent.VK_S:
                    player.move(2, 1);
                    break;
                case KeyEvent.VK_D:
                    player.move(3, 1);
                    break;
                case KeyEvent.VK_SPACE:
                    player.interact();
            }
        }
        frame.repaint();
    }
    @Override
    public void draw(Graphics g) {
        for(Entity entity : spawn){
            entities.add(entity);
        }
        for(Entity entity : remove){
            entities.remove(entity);
        }
        for(Entity entity : entities){
            entity.draw(g);
        }
        spawn.clear();
        remove.clear();
    }

    public Iterator getEntitiesIterator(){
        return entities.iterator();
    }
    public void update(){
        updating = true;

        for(Entity entity: entities) {
            if (entity instanceof Interactable)
                ((Interactable) entity).update();
        }
        updating = false;

    }
    public void spawner(Entity entity){
        spawn.add(entity);
    }
    public void remover(Entity entity){
        remove.add(entity);
    }
    public Optional<Entity> getEntity(int xGrid, int yGrid){
        for(Entity entity: entities){
            if(entity.getXPos() == xGrid && entity.getYPos() == yGrid)
                return Optional.of(entity);
        }
        return null;
    }
}
