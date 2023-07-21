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
        
        for (int i = 0; i < 2; i++) {
            Virus1 v = new Virus1();
            addRandomObject(v, rand);
        }
    }
    
    public void randomSyringe(){
        Random rand = new Random();
    
        for (int i = 0; i < 4; i++) {
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
}


