package PhoneBook;

public class TimeController {

    public static long doTheTime(long lastTime) {
        long newTime;
        newTime = System.currentTimeMillis() - lastTime;
        return newTime;

    }

    public static void printTheTime(long newTime, String message) {
        long min, sec, milisec;
        min = newTime / 60000;
        sec = (newTime - min * 60000) / 1000;
        milisec = (newTime - min * 60000 - sec * 1000);
        System.out.println(message + ": " + min +
                " min. " + sec + " sec. " + milisec + " ms.");
        }

    public static void printFailedSortTime(long newTime) {
        long min, sec, milisec;
        min = newTime / 60000;
        sec = (newTime - min * 60000) / 1000;
        milisec = (newTime - min * 60000 - sec * 1000);
        System.out.println("Sorting time: " + min +
                " min. " + sec + " sec. " + milisec + " ms. - STOPPED, moved to linear search");
    }
}
