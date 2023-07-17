import lang.stride.*;
import java.util.*;
import greenfoot.*;
import java.util.Random;

/**
 * 
 */
public class Marketworld extends World
{

    /**
     * Constructor for objects of class Marketworld.
     */
    public Marketworld()
    {
        super(600, 400, 1);
        setBackground("supermarket-scenario.png");
        setp1();
        randomEnemys();
        
    }
    
    public void setp1(){
        Player1 p1 = new Player1();
        addObject(p1,400,150);
    }
    
    public void randomEnemys(){
        Random rand = new Random();
        
        Virus1 v1 = new Virus1();
        addObject(v1,rand.nextInt(500),rand.nextInt(500));
        
        Virus1 v2 = new Virus1();
        addObject(v2,rand.nextInt(500),rand.nextInt(500));
        
        Virus1 v3 = new Virus1();
        addObject(v3,rand.nextInt(500),rand.nextInt(500));
        
        Virus1 v4 = new Virus1();
        addObject(v4,rand.nextInt(500),rand.nextInt(500));
        
    }
}
