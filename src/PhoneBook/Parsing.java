package PhoneBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Parsing {

    /*
        fileName is going to be "find" either "dir", where
        "find" stands for file.txt file
        "dir" stands for directory.txt file
     */
    public static String gimmeThatPath(boolean dirOrFind) {
        Path pathName = Paths.get("");
        String newPathName = pathName.toAbsolutePath().toString();
        if (dirOrFind) {
            newPathName += "\\find.txt";
        } else {
            newPathName += "\\directory_orig.txt";
        }
        return newPathName;
    }

    public static String[] gimmeThatArray(File fileName, boolean dirOrFind) {
        /*
        dirOrFind = true - stands for find.txt
        dirOrFind = false - stands for directory.txt
         */
        String tmp = "";
        String str = "";
        try (Scanner scan = new Scanner(fileName)) {
            tmp = scan.nextLine();
            while (!tmp.equals("")) {
                str = str + tmp;
                try {
                    tmp = "#" + scan.nextLine();
                } catch (Exception e) {
                    tmp = "";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return str.split("#");
    }
    public static int howManyFound(File fileName, String[] findArray) {
        int found = 0;
        String tmp = "";
        char[] findCharArray;
        char[] dirCharArray;
        try (Scanner scan = new Scanner(fileName)) {
            while (scan.hasNext()) {
                tmp = scan.nextLine();
                for (int i = 0; i < findArray.length; i++) {
                    findCharArray = findArray[i].toCharArray();
                    dirCharArray = tmp.toCharArray();
                    for (int j = findCharArray.length - 1, l = dirCharArray.length - 1;
                         j >= 0 && l >= 0; j--, l--) {
                        if (findCharArray[j] != dirCharArray[l]) {
                            break ;
                        }
                        if (j == 0) {
                            found++;
                        }

                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error in howManyFound");
            System.exit(1);
        }
        return found;
    }
}

//    public static String[] gimmeThatArray(File fileName, boolean dirOrFind) {
//        /*
//        dirOrFind = true - stands for find.txt
//        dirOrFind = false - stands for directory.txt
//         */
//        String tmp = "";
//        String[] tmpArray;
//        String str = "";
//        try (Scanner scan = new Scanner(fileName)) {
//            tmp = dirOrFind ? scan.nextLine() : (scan.next() + "#" + scan.nextLine()).split("#")[1].trim();
//            while (!tmp.equals("")) {
//                str = str + tmp;
//                try {
//                    if (dirOrFind) {
//                        tmp = "#" + scan.nextLine();
//                    } else {
//                        tmpArray = scan.nextLine().split(" ");
//                        tmp = "#";
//                        for (int i = 1; i < tmpArray.length; i++) {
//                            tmp += tmpArray[i];
//                            if (i + 1 < tmpArray.length) {
//                                tmp += " ";
//                            }
//                        }
//                    }
//                } catch (Exception e) {
//                    tmp = "";
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Error");
//        }
//        return str.split("#");
//    }
//}
