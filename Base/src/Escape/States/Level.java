package Escape.States;

import Escape.Entities.*;
import Escape.Entities.Box;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;



public class Level extends State{
    final int dimension = 50;
    final int gridX = 38;
    final int gridY = 25;
    private Player player;
    private ArrayList<Entity> animated = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Entity> spawn = new ArrayList<>();
    private ArrayList<Entity> remove = new ArrayList<>();
    private Dictionary links;
    boolean updating;



    public Level(String name, String levelFile, String linkFile, JPanel frame) throws IOException {
        super(name, frame);
        BufferedReader reader1 = new BufferedReader(new FileReader(new File(levelFile)));
        BufferedReader reader2 = new BufferedReader(new FileReader(new File(linkFile)));
        String currentLine;
        char currentChar;
        int y = 0;
        Entity store;
        Optional<Entity> entity;
        ArrayList<Entity> linked;
        Map<Character, ArrayList<Entity>> links = new HashMap<>();
        while ((currentLine = reader1.readLine()) != null) {
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
        y = 0;
        while ((currentLine = reader2.readLine()) != null) {
            for(int x = 0; x < gridX; x++) {
                currentChar = currentLine.charAt(x);
                if (currentChar != '0'){
                    entity = getEntity(x, y);
                    if(links.containsKey(currentChar)) {
                            links.get(currentChar).add(entity.get());
                    }
                    else{
                            links.put(currentChar,new ArrayList<>());
                            links.get(currentChar).add(entity.get());
                    }
                }
            }
            y++;
        }
        for (Map.Entry<Character, ArrayList<Entity>> link : links.entrySet()) {
            linked = link.getValue();
            if(linked.get(0) instanceof Linkable){
                ((Linkable) linked.get(0)).link(linked.get(1));
            }
            if(linked.get(1) instanceof Linkable){
                ((Linkable) linked.get(1)).link(linked.get(0));
            }
        }
        reader1.close();
        reader2.close();
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
            case 'B':
                return new Box(x, y,this);
            case 'L':
                return new LightSwitch(x, y, this);
            case 'D':
                return new Door(x, y, this);
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
        if(!updating) {
            for (Entity entity : spawn) {
                entities.add(entity);
            }
            for (Entity entity : remove) {
                entities.remove(entity);
            }
            for (Entity entity : entities) {
                entity.draw(g);
            }
            spawn.clear();
            remove.clear();
        }
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
