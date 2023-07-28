
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Actor
{
    /**
     * Act - do whatever the player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean alive = true;
    private int health = 100;
    private int speed = 2;
    private String currentDirection = "right";
    private GreenfootSound themeSound;
    private boolean themePlaying;
    private int shotDelay  = 0;
    private GreenfootSound deathSound;
    private boolean deathPlaying;
    private GreenfootSound syringeSound;
    private boolean syringePlaying;
    private int syringeCount;

    public Player1(){
        GreenfootImage image = getImage();
        image.scale(12,17);
        setImage(image);
        themeSound = new GreenfootSound("Jeepeta.wav");
        themePlaying = false;
        deathSound = new GreenfootSound("Death.wav");
        deathPlaying = false;
        syringeSound = new GreenfootSound("Syringe.wav");
        syringeCount = 0;
    }
    
    public void act()
    {
        if(this.alive == true){
            hitDetection(); 
            hitDetectionSyringe();
            playTheme();    
            int dx = 0, dy = 0;
            if (this.shotDelay > 0) this.shotDelay--;
            if(Greenfoot.isKeyDown("space") && this.shotDelay == 0) { 
                int p1x = getX();
                int p1y = getY();
                Proyectile p = new Proyectile(this.currentDirection);
                getWorld().addObject(p,p1x,p1y);
                this.shotDelay = 30;
            }
            
            if (Greenfoot.isKeyDown("w")){dy = -this.speed;this.currentDirection = "up";}
            if (Greenfoot.isKeyDown("a")) {dx = -this.speed; this.currentDirection = "left"; }
            if (Greenfoot.isKeyDown("s")) {dy = this.speed;this.currentDirection = "down";}
            if (Greenfoot.isKeyDown("d")) {dx = this.speed; this.currentDirection = "right"; }
            setLocation(getX()+dx, getY()+dy);

            if (wallDetection() == true)
            {
                setLocation(getX()-dx, getY()-dy);
            }
            
            if (currentDirection.equals("left")) {
                setImage("p1left.png");
                GreenfootImage image = getImage();
                image.scale(12,17);
                setImage(image);
            } else if (currentDirection.equals("right")) {
                setImage("p1.png");
                GreenfootImage image = getImage();
                image.scale(12,17);
                setImage(image);
            }
            World world = getWorld();
            world.showText("Score: " + syringeCount, 50, 25);
        }else{
            World world = getWorld();
            Gameover over = new Gameover("gameover.png");
            Blackwhite filter = new Blackwhite("bwfilter.png");
            world.addObject(over,300,200);
            world.addObject(filter,300,200);
            stopTheme();
            deathTheme();
        }
    }
    
    public void lvlPassed(){
        if(this.syringeCount % 10 == 0){
            int level = (int) this.syringeCount/10;
            Marketworld myWorld = (Marketworld) getWorld();
            if(myWorld!=null){
            if(level != myWorld.getLevel()){
                myWorld.setLevel(level);
                    }
                }
            }
    
        }
    
    public boolean wallDetection(){
        Actor w1 = getOneIntersectingObject(Cashier.class);
        Actor w2 = getOneIntersectingObject(Drinks.class);
        Actor w3 = getOneIntersectingObject(EastL.class);
        Actor w4 = getOneIntersectingObject(Fruits.class);
        Actor w5 = getOneIntersectingObject(Muffin.class);
        Actor w6 = getOneIntersectingObject(NorthL.class);
        Actor w7 = getOneIntersectingObject(Shelve.class);
        Actor w8 = getOneIntersectingObject(SouthL.class);
        Actor w9 = getOneIntersectingObject(WestL.class);
        
        if( w1!=null || w2!=null || w3!=null || w4!=null || w5!=null || w6!=null || w7!=null || w8!=null || w9!=null ){
            return true;
        }else{
            return false;
        }
    }
    
    public void hitDetection(){ 
   
           Actor b = getOneIntersectingObject(Virus1.class);  
              
           if(b != null)  
           {    
               if (!getWorld().getObjects(Player1.class).isEmpty()){
               this.alive = false;
            }
           } 
    }
    
     public void hitDetectionSyringe() {
        if (isTouching(Syringe.class)) {
            removeTouching(Syringe.class);
            syringeCount++;
            lvlPassed();
            syringeTheme();
            syringePlaying = false;
        }
    }

    public int getSyringeCount() {
        return syringeCount;
    }
    
    public void resetSyringeCount() {
        syringeCount = 0;
    }
    
    public void playTheme() {
        if (!themePlaying) {
            themeSound.playLoop();
            themePlaying = true;
        }
    }

    public void stopTheme() {
        themeSound.stop();
    }
    
    public void deathTheme() {
        if (!deathPlaying) {
            deathSound.play();
            deathPlaying = true;
        }
    }
    
    public void syringeTheme() {
        if (!syringePlaying) {
            syringeSound.play();
            syringePlaying = true;
        }
    }
}