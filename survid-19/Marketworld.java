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
        SetShelves();
        SetNorthL();
        SetSouthL();
        SetEastL();
        SetWestL();
        SetFruits();
        SetDrinks();
        SetCashier();
        SetMuffin();
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

    public void SetShelves(){
        int[][] shelveCoordinates = {
            {110, 173},
            {166, 173},
            {222, 173},
            {278, 173},
            {334, 173},
            {520, 173},
            {575, 173}
        };
        
        for (int i = 0; i < shelveCoordinates.length; i++) {
            Shelve s = new Shelve();
            addObject(s, shelveCoordinates[i][0], shelveCoordinates[i][1]);
        }
    }
    
    public void SetNorthL(){
        int[][] NorthLCoordinates = {
            {204, 70},
            {600, 70}
        };
        
        for (int i = 0; i < NorthLCoordinates.length; i++) {
            NorthL NL = new NorthL();
            addObject(NL, NorthLCoordinates[i][0], NorthLCoordinates[i][1]);
        }
    }
    
    public void SetSouthL(){
        int[][] SouthLCoordinates = {
            {204, 400},
            {600, 400}
        };
        
        for (int i = 0; i < SouthLCoordinates.length; i++) {
            SouthL SL = new SouthL();
            addObject(SL, SouthLCoordinates[i][0], SouthLCoordinates[i][1]);
        }
    }
    
    public void SetEastL(){
        EastL E1 = new EastL();
        addObject(E1, 600, 204);
    }
    
    public void SetWestL(){
        WestL E1 = new WestL();
        addObject(E1, 0, 247);
    }
    
    public void SetFruits(){
        int[][] FruitsCoordinates = {
            {49, 185},
            {49, 232},
            {457, 185},
            {457, 232}
        };
        
        for (int i = 0; i < FruitsCoordinates.length; i++) {
            Fruits F = new Fruits();
            addObject(F, FruitsCoordinates[i][0], FruitsCoordinates[i][1]);
        }
    }
    
    public void SetDrinks(){
        int[][] DrinksCoordinates = {
            {49, 296},
            {49, 351},
            {121, 296},
            {121, 351},
            {456, 296},
            {456, 351},
            {529, 296},
            {529, 351}
        };
        
        for (int i = 0; i < DrinksCoordinates.length; i++) {
            Drinks D = new Drinks();
            addObject(D, DrinksCoordinates[i][0], DrinksCoordinates[i][1]);
        }
    }
    
    public void SetCashier(){
        int[][] CashierCoordinates = {
            {188, 327},
            {235, 327},
            {284, 327},
            {332, 327},
            {589, 327}
        };
        
        for (int i = 0; i < CashierCoordinates.length; i++) {
            Cashier C = new Cashier();
            addObject(C, CashierCoordinates[i][0], CashierCoordinates[i][1]);
        }
    }
    
    public void SetMuffin(){
        int[][] MuffinCoordinates = {
            {49, 125},
            {457, 125}
        };
        
        for (int i = 0; i < MuffinCoordinates.length; i++) {
            Muffin M = new Muffin();
            addObject(M, MuffinCoordinates[i][0], MuffinCoordinates[i][1]);
        }
    }
}