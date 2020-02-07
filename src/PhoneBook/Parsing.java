package PhoneBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parsing {

    static File gimmeThatFile(boolean dirOrFind) {
        File fileName = new File("");
        String workindDir  = System.getProperty("user.dir");
        String whatSystemIsThat = System.getProperty("os.name").split(" ")[0];
        if (whatSystemIsThat.equals("Mac")) {
            if (dirOrFind) {
                fileName = new File(workindDir + "/find.txt");
            } else {
                fileName = new File(workindDir + "/directory_orig.txt");
            }
        }
        return fileName;
    }

    public static String[] gimmeThatArray(boolean dirOrFind) {
        /*
        dirOrFind = true - stands for find.txt
        dirOrFind = false - stands for  directory.txt
         */
        String tmp = "";
        String str = "";
        File fileName = gimmeThatFile(dirOrFind);
        String[] strArray = new String[1];
        try (Scanner scan = new Scanner(fileName)) {
            strArray = new String[dirOrFind ? 500 : 1014130];
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

}
