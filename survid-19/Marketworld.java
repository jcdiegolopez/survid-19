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
    private int lvl;
    private boolean isThemePlaying = false;


    /**
     * Constructor for objects of class Marketworld.
     */
    public Marketworld()
    {
        super(600, 400, 1);
        setBackground("supermarket-scenario.png");
        setp1();
        this.lvl = 1;
        SetShelves();
        SetNorthL();
        SetSouthL();
        SetEastL();
        SetWestL();
        SetFruits();
        SetDrinks();
        SetCashier();
        SetMuffin();
        randomEnemies();
        randomSyringe();
    }
    
    public void setp1(){
        p1 = new Player1();
        addObject(p1, 400, 200);
    }
    
    public void randomEnemies() {
    Random rand = new Random();
    int numberOfEnemies = 4;
    placeRandomActors(Virus1.class, numberOfEnemies, rand);
    }

    public void randomSyringe() {
        Random rand = new Random();
        int numberOfSyringes = 10;
        placeRandomActors(Syringe.class, numberOfSyringes, rand);
    }

    private void placeRandomActors(Class actorClass, int numActors, Random rand) {
    int gridSize = 40; 
    int worldWidth = getWidth();
    int worldHeight = getHeight();
    int numCols = worldWidth / gridSize;
    int numRows = worldHeight / gridSize;

    for (int i = 0; i < numActors; i++) {
        int x, y;
        do {
            x = rand.nextInt(numCols) * gridSize + gridSize / 2;
            y = rand.nextInt(numRows) * gridSize + gridSize / 2;
        } while (getObjectsAt(x, y, Actor.class).size() > 0);

        try {
            Actor actor = (Actor) actorClass.newInstance();
            addObject(actor, x, y);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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
            {204, 35},
            {780, 39}
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