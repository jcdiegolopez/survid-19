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
    private int numberOfEnemies;
    private boolean isThemePlaying = false;
    private GreenfootSound levelSound;
    private boolean levelPlaying;

    /**
     * Constructor for objects of class Marketworld.
     */
    public Marketworld()
    {
        super(600, 400, 1);
        setBackground("supermarket-scenario.png");
        setp1();
        this.lvl = 0;
        this.numberOfEnemies = 3;
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
        levelSound = new GreenfootSound("Levelup.wav");
        clock();
    }
    
    public void setLevel(int lvl){
        this.lvl = lvl;
        this.numberOfEnemies += 2;
        randomEnemies();
        randomSyringe();
        levelTheme();
        levelPlaying = false;
    }
    
    public int getLevel(){
        return this.lvl;
    }
    
    public void setp1(){
        p1 = new Player1();
        addObject(p1, 400, 200);
    }
    
    public void randomEnemies() {
    Random rand = new Random();
    placeRandomActorsOnEdges(Virus1.class, this.numberOfEnemies, rand);
    }

    public void randomSyringe() {
        Random rand = new Random();
        int numberOfSyringes = 10;
        placeRandomActors(Syringe.class, numberOfSyringes, rand);
    }
    
    private void placeRandomActorsOnEdges(Class actorClass, int numActors, Random rand) {
    int gridSize = 40; 
    int worldWidth = getWidth();
    int worldHeight = getHeight();
    int numCols = worldWidth / gridSize;
    int numRows = worldHeight / gridSize;

    for (int i = 0; i < numActors; i++) {
        int x, y;
        // Determine on which edge to place the actor (0: top, 1: right, 2: bottom, 3: left)
        int edge = rand.nextInt(4);

        switch (edge) {
            case 0: // Top edge
                x = rand.nextInt(numCols) * gridSize + gridSize / 2;
                y = gridSize / 2;
                break;
            case 1: // Right edge
                x = worldWidth - gridSize / 2;
                y = rand.nextInt(numRows) * gridSize + gridSize / 2;
                break;
            case 2: // Bottom edge
                x = rand.nextInt(numCols) * gridSize + gridSize / 2;
                y = worldHeight - gridSize / 2;
                break;
            case 3: // Left edge
                x = gridSize / 2;
                y = rand.nextInt(numRows) * gridSize + gridSize / 2;
                break;
            default:
                x = rand.nextInt(numCols) * gridSize + gridSize / 2;
                y = rand.nextInt(numRows) * gridSize + gridSize / 2;
                break;
        }

        try {
            Actor actor = (Actor) actorClass.newInstance();
            addObject(actor, x, y);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}

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
    
    public void clock(){
        Clock Cl1 = new Clock();
        addObject(Cl1, 470, 25);
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
    
        public void levelTheme() {
        if (!levelPlaying) {
            levelSound.play();
            levelPlaying = true;
        }
    }
}