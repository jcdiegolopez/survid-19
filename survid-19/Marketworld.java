import lang.stride.*;
import java.util.*;
import greenfoot.*;
import java.util.Random;

/**
 * 
 */
public class Marketworld extends World
{
    private Player1 p1;

    /**
     * Constructor for objects of class Marketworld.
     */
    public Marketworld()
    {
        super(600, 400, 1);
        setBackground("supermarket-scenario.png");
        setp1();
        randomEnemies();
        randomSyringe();
    }
    
    public void setp1(){
        p1 = new Player1();
        addObject(p1, 400, 200);
    }
    
    public void randomEnemies(){
        Random rand = new Random();
        
        for (int i = 0; i < 4; i++) {
            Virus1 v = new Virus1();
            addRandomObject(v, rand);
        }
    }
    
    public void randomSyringe(){
        Random rand = new Random();
    
        for (int i = 0; i < 3; i++) {
            Syringe s = new Syringe();
            addRandomObject(s, rand);
        }
    }
    
   
    
    private void addRandomObject(Actor object, Random rand) {
        int x, y;
        do {
            x = rand.nextInt(getWidth());
            y = rand.nextInt(getHeight());
        } while (getObjectsAt(x, y, Actor.class).size() > 0);
        
        addObject(object, x, y);
    }
    
    // Act method for the Marketworld
    public void act() {
        ///movePlayerTowardsSyringe();
    }
    
    private void movePlayerTowardsSyringe() {
        Syringe nearestSyringe = findNearestSyringe();
        if (nearestSyringe != null) {
            int playerX = p1.getX();
            int playerY = p1.getY();
            int syringeX = nearestSyringe.getX();
            int syringeY = nearestSyringe.getY();
            int deltaX = syringeX - playerX;
            int deltaY = syringeY - playerY;
            
            // Check if the player is close to the syringe
            int distanceToSyringe = (int) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            if (distanceToSyringe > 5) {
                int moveSpeed = 2;
                int moveX = deltaX > 0 ? moveSpeed : -moveSpeed;
                int moveY = deltaY > 0 ? moveSpeed : -moveSpeed;
                p1.setLocation(playerX + moveX, playerY + moveY);
            }
        }
    }
    
    private Syringe findNearestSyringe() {
        List<Syringe> syringes = getObjects(Syringe.class);
        if (syringes.isEmpty()) {
            return null;
        }
        
        int playerX = p1.getX();
        int playerY = p1.getY();
        
        Syringe nearestSyringe = syringes.get(0);
        int minDistance = Integer.MAX_VALUE;
        
        for (Syringe syringe : syringes) {
            int syringeX = syringe.getX();
            int syringeY = syringe.getY();
            int deltaX = syringeX - playerX;
            int deltaY = syringeY - playerY;
            int distance = deltaX * deltaX + deltaY * deltaY;
            if (distance < minDistance) {
                minDistance = distance;
                nearestSyringe = syringe;
            }
        }
        
        return nearestSyringe;
    }
}


