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
    
    public Player1(){
        GreenfootImage image = getImage();
        image.scale(40,40);
        setImage(image);
    }
    
    public void act()
    {
        if(this.alive == true){
            hitDetection();
            if (Greenfoot.isKeyDown("w")){
                setLocation(getX(),getY()-3);
            }
            if (Greenfoot.isKeyDown("s")){
                setLocation(getX(),getY()+3);
            }
            if (Greenfoot.isKeyDown("d")){
                setLocation(getX()+3,getY());
            }
            if (Greenfoot.isKeyDown("a")){
                setLocation(getX()-3,getY());
            }
        }else{
            World world = getWorld();
            Gameover over = new Gameover("gameover.png");
            Blackwhite filter = new Blackwhite("bwfilter.png");
            world.addObject(over,300,200);
            world.addObject(filter,300,200);
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
}
