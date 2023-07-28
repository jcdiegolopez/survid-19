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
    public int syringeCount = 0;
    private GreenfootSound themeSound;
    private boolean themePlaying;
    private int shotDelay  = 0;
    
    public Player1(){
        GreenfootImage image = getImage();
        image.scale(12,17);
        setImage(image);
        themeSound = new GreenfootSound("SuperMarket_Theme.wav");
        themePlaying = false;
        
    }
    
    public void act()
    {
        GreenfootSound themeSound = new GreenfootSound("SuperMarket_Theme.wav");

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
            
            if (Greenfoot.isKeyDown("w"))dy = -this.speed;
            if (Greenfoot.isKeyDown("a")) {dx = -this.speed; this.currentDirection = "left"; }
            if (Greenfoot.isKeyDown("s")) dy = this.speed;
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
        }
    }

     public int getSyringeCount() {
        return syringeCount;
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
}