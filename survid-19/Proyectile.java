import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Proyectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Proyectile extends Actor
{
    /**
     * Act - do whatever the Proyectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String direction;
    private int movement = 4;
    private boolean exist = true;
    private GreenfootSound laserSound;
    private boolean laserPlaying;
    public Proyectile(String direction){
        this.direction = direction;
        setImageDir();
        laserSound = new GreenfootSound("Laser.wav");
        laserPlaying = false;
    }
    
    public void setImageDir(){
        if(this.direction.equals("right")){
            setImage("proyectile.png");
            GreenfootImage image = getImage();
            image.scale(12,7);
            setImage(image);
        }
        if(this.direction.equals("left")){
            setImage("proyectileL.png");
            GreenfootImage image = getImage();
            image.scale(12,7);
            setImage(image);
        }
        if(this.direction.equals("up")){
            setImage("proyectileup.png");
            GreenfootImage image = getImage();
            image.scale(7,12);
            setImage(image);
        }
        if(this.direction.equals("down")){
            setImage("proyectiledown.png");
            GreenfootImage image = getImage();
            image.scale(7,12);
            setImage(image);
        }
        
    }
    public void act()
    {
        if(this.exist){
        playLaser();
        
        if(this.direction == "right")  setLocation(getX() + this.movement, getY());
        if(this.direction == "left")  setLocation(getX() - this.movement, getY());
        if(this.direction == "up")  setLocation(getX(), getY()-this.movement);
        if(this.direction == "down")  setLocation(getX(), getY()+this.movement);
        hitDetection();
    }
    }
    
    
     public void hitDetection(){  
       if(wallDetection()){
           getWorld().removeObject(this);
           this.exist = false;
        }else{

       Actor b = getOneIntersectingObject(Virus1.class);  
        
       if(b != null)  
       {  
           getWorld().removeObject(b);   
           getWorld().removeObject(this);
           this.exist = false;
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
    
        
        public void playLaser() {
        if (!laserPlaying) {
            laserSound.play();
            laserPlaying = true;
        }
    }

    public void stopTheme() {
        laserSound.stop();
    }
}
