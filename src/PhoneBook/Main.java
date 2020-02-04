package PhoneBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int foundSuc = 0;
        long time = 0, parseTime = 0;
        String[] dirArray;
        String[] findArray;
        File readFromThisFileFind = new File(Parsing.gimmeThatPath(true));
        File readFromThisFileDir = new File(Parsing.gimmeThatPath(false));
        parseTime = System.currentTimeMillis();
        findArray = Parsing.gimmeThatArray(readFromThisFileFind, true);
        //TimeControler.printTheTime(parseTime, "Find parsing. ");
        time = System.currentTimeMillis();
        foundSuc = Parsing.howManyFound(readFromThisFileDir, findArray);
        System.out.print("Found " + foundSuc + " / " + findArray.length + " entries. ");
        TimeControler.printTheTime(time, "");
        System.exit(0);
       // dirArray = Parsing.gimmeThatArray(readFromThisFileDir, false);
        //TimeControler.printTheTime(parseTime, "Parsing process. ");
//        time = System.currentTimeMillis();
//        for (int i = 0; i < findArray.length; i++) {
//        	for (int j = 0, l = dirArray.length - 1; j < dirArray.length && l >= j; j++, l--) {
//        		if (findArray[i].equals(dirArray[j]) || findArray[i].equals(dirArray[l])) {
//        			foundSuc++;
//        			break ;
//		        }
//	        }
//        }
//        System.out.println("Found " + foundSuc + " / " + findArray.length + " entries. ");
//        TimeControler.printTheTime(time, "");
    }
}
