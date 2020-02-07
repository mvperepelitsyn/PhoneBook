package PhoneBook;

public class TimeControler {
    public static void printTheTime(long lastTime, String message) {
        long newTime = 0, min = 0, sec = 0, milisec = 0;
        newTime = System.currentTimeMillis() - lastTime;
        min = newTime / 60000;
        sec = (newTime - min * 60000) / 1000;
        milisec = (newTime - min * 60000 - sec * 1000);
        System.out.println(message + "Time taken: " + min +
                " min. " + sec + " sec. " + milisec + " ms.");
    }
}
