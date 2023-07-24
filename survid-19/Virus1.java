import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class virus1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Virus1 extends Actor
{
    /**
     * Act - do whatever the virus1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Virus1(){
        setImage("e1.png");
        GreenfootImage image = getImage();
        image.scale(25,25);
        setImage(image);
        
    }
    public void act()
    {
        if(!getWorld().getObjects(Player1.class).isEmpty()){
        Actor player1 = getWorld().getObjects(Player1.class).get(0);
        Approach(player1);
        }
    }
    
    public void Approach (Actor p1){
    
        int playerX = p1.getX();
        int playerY = p1.getY();
        int virusX = getX();
        int virusY = getY();
        int deltaX = playerX - virusX;
        int deltaY = playerY - virusY;
        
        
        int moveSpeed = 1;
        int moveX = deltaX > 0 ? moveSpeed : -moveSpeed;
        int moveY = deltaY > 0 ? moveSpeed : -moveSpeed;
        setLocation(virusX + moveX, virusY + moveY);
        
        
    }
}
