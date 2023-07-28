import greenfoot.*;

public class Clock extends Actor {
    private long startTime; // Tiempo de inicio del contador

    public Clock() {
        startTime = System.currentTimeMillis(); // Inicializar el tiempo de inicio al crear el objeto
    }

    public void act() {
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000; // Tiempo transcurrido en segundos
        String tiempoTranscurrido = formatTime(elapsedTime); // Formatear el tiempo en HH:mm:ss
        setImage(new GreenfootImage(tiempoTranscurrido, 30, Color.GRAY, new Color(0, 0, 0, 0))); // Mostrar el tiempo en el actor
    }

    private String formatTime(long segundos) {
        long minutos = (segundos % 3600) / 60;
        long secs = segundos % 60;
        return String.format("%02d:%02d", minutos, secs);
    }
}
