package PhoneBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String tmp = "";
        String mainStr = "";
        File readFromThisFile = new File("/Users/dfrost-a/Desktop/Phonebook/find.txt");
        try (Scanner scan = new Scanner(readFromThisFile)) {
            mainStr = scan.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
}
