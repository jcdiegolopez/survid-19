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
    private int speed = 3;
    
    public Player1(){
        GreenfootImage image = getImage();
        image.scale(15,25);
        setImage(image);
    }
    
    public void act()
    {
        if(this.alive == true){
            hitDetection(); 
            int dx = 0, dy = 0; 
            if (Greenfoot.isKeyDown("w")) dy = -this.speed;
            if (Greenfoot.isKeyDown("a")) dx = -this.speed;
            if (Greenfoot.isKeyDown("s")) dy = this.speed;
            if (Greenfoot.isKeyDown("d")) dx = this.speed;
            setLocation(getX()+dx, getY()+dy);

            if (wallDetection() == true)
            {
                setLocation(getX()-dx, getY()-dy);
            }
  
        }else{
            World world = getWorld();
            Gameover over = new Gameover("gameover.png");
            Blackwhite filter = new Blackwhite("bwfilter.png");
            world.addObject(over,300,200);
            world.addObject(filter,300,200);
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
}
