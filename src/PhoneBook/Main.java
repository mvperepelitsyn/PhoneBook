package PhoneBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static String[] gimmeThatArray(File fileName, boolean dirOrFind) {
        /*
        dirOrFind = true - stands for directory.txt
        dirOrFind = false - stands for find.txt
         */
        String tmp = "";
        String str = "";
        String[] strArray = new String[1];
        try (Scanner scan = new Scanner(fileName)) {
            strArray = new String[dirOrFind ? 1014130 : 500];
            tmp = scan.nextLine();
            for (int i = 0; i < strArray.length && !tmp.equals(""); i++) {
                strArray[i] = tmp;
                try {
                    tmp = scan.nextLine();
                } catch (Exception e) {
                    tmp = "";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return strArray;
    }

    public static String gimmeThatName(String dirStr) {
        String[] nameArray = dirStr.split(" ");
        String nameStr = "";
        for (int i = 1; i < nameArray.length; i++) {
            nameStr = nameStr + nameArray[i];
            if (i + 1 < nameArray.length) {
                nameStr = nameStr + " ";
            }
        }
        return nameStr;
    }

    public static void main(String[] args) {
        String tmp = "";
        int foundSuc = 0;
        long time = 0, min = 0, sec = 0, milisec = 0;
        long timeParse;
        String findStr = "";
        String dirStr = "";
        String[] dirArray;
        String[] findArray;
        File readFromThisFileFind = new File("/Users/dfrost-a/Desktop/Phonebook/find.txt");
        File readFromThisFileDir = new File("/Users/dfrost-a/Desktop/Phonebook/directory_orig.txt");
//        timeParse = System.currentTimeMillis();
        findArray = gimmeThatArray(readFromThisFileFind, false);
        dirArray = gimmeThatArray(readFromThisFileDir, true);
//        timeParse = System.currentTimeMillis() - timeParse;
//        min = timeParse / 60000;
//        sec = (timeParse - min * 60000) / 1000;
//        milisec = (timeParse - min * 60000 - sec * 1000);
//        System.out.println("Parsing took " + min + " min. " + sec + " sec. " + milisec + " ms.");
        time = System.currentTimeMillis();
        for (int i = 0; i < findArray.length; i++) {
            for (int j = 0; j < dirArray.length; j++) {
                if (findArray[i].equals(gimmeThatName(dirArray[j]))) {
                    foundSuc++;
                    break ;
                }
            }
//        	for (int j = 0, l = dirArray.length - 1; j < dirArray.length && l >= j; j++, l--) {
//        		if (findArray[i].equals(dirArray[j]) || findArray[i].equals(dirArray[l])) {
//        			foundSuc++;
//        			break ;
//		        }
//	        }
        }
        time = System.currentTimeMillis() - time;
        min = time / 60000;
        sec = (time - min * 60000) / 1000;
        milisec = (time - min * 60000 - sec * 1000);
        System.out.println("Found " + foundSuc + " / " + findArray.length + " entries. Time taken: " +
                 min + " min. " + sec + " sec. " + milisec + " ms.");
    }
}
