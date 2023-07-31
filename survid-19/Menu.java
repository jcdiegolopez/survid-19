import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    Arrow arrow = new Arrow();
    private int option = 0;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        super(550, 706, 1);
        addObject(new Play(), 275, 300);
        addObject(new Exit(), 275, 400);
        addObject(arrow, 130, 300);
        addObject(new Logo(),280,160);
    }
    
    public void act(){
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("UP") && option !=0) {
            option++;
        }
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("DOWN") && option !=1) {
            option--;
        }
        
        if (option>=2) option =0;
        if (option<0) option = 1;
        
        arrow.setLocation(130, 300 + (option * 100));
        
        if (Greenfoot.isKeyDown("SPACE") || Greenfoot.isKeyDown("ENTER")){
            switch(option){
                case 0:
                    Greenfoot.setWorld(new Marketworld());
                    break;
                case 1: 
                    Greenfoot.stop();
                    break;
                
            }
        }
    }
}
