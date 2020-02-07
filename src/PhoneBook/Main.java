package PhoneBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int foundSuc = 0;
        long time;
        long timeParse;
        String[] dirArray;
        String[] findArray;
        timeParse = System.currentTimeMillis();
        findArray = Parsing.gimmeThatArray(true);
        dirArray = Parsing.gimmeThatArray(false);
        TimeControler.printTheTime(timeParse, "Parsing took:");
        time = System.currentTimeMillis();
        foundSuc = Searches.linearSearch(findArray, dirArray);
        System.out.print("Found " + foundSuc + " / " + findArray.length + " entries. ");
        TimeControler.printTheTime(time, "Time taken");
    }
}
