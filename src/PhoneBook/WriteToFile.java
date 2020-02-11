package PhoneBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    static void writeToTheFile(String nameOfTheFile, String[] arrayToFill) throws IOException {
        File file = null;
        String workindDir  = System.getProperty("user.dir");
        String whatSystemIsThat = System.getProperty("os.name").split(" ")[0];
        try {
            if (whatSystemIsThat.equals("Mac")) {
                file = new File(workindDir + "/" + nameOfTheFile);
            } else if (whatSystemIsThat.equals("Windows")) {
                file = new File(workindDir + "\\find.txt");
            }
        } catch (Exception e) {
            System.out.println("There is a mistake during openning a file for its filling!");
            System.exit(69);
        }
        if (file == null) {
            System.exit(69);
        }
        FileWriter writer = new FileWriter(file, true); // appends text to the file
        for (int i = 0; i < arrayToFill.length - 1; i++) {
            writer.write(arrayToFill[i] + "\n");
        }
        writer.close();
    }
}
