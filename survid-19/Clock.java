import greenfoot.*;

public class Clock extends Actor {
    public long startTime;
    private boolean isPaused;

    public Clock() {
        startTime = System.currentTimeMillis();
    }

    public void act() {
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000; 
        String timeE = formatTime(elapsedTime);
        setImage(new GreenfootImage(timeE, 30, Color.GRAY, new Color(0, 0, 0, 0)));
    }

    private String formatTime(long seconds) {
        long minutos = (seconds % 3600) / 60;
        long secs = seconds % 60;
        return String.format("%02d:%02d", minutos, secs);
    }
}
