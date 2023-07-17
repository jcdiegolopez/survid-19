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
        image.scale(40,40);
        setImage(image);
        setLocation(100,100);
    }
    public void act()
    {
        // Add your action code here.
    }
}
