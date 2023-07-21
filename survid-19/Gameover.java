import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gameover extends Actor
{
    /**
     * Act - do whatever the gameover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Gameover(String filename){
        setImage(new GreenfootImage(filename));
        GreenfootImage image = getImage();
        image.scale(300,300);
        setImage(image);
    }
    public void act()
    {
        
    }
}
