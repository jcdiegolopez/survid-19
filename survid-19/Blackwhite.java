import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blackwhite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blackwhite extends Actor
{
    /**
     * Act - do whatever the Blackwhite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Blackwhite(String filename){
        setImage(new GreenfootImage(filename));
        GreenfootImage image = getImage();
        image.scale(700,400);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
