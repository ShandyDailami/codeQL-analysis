import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24012_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path

        try {
            File dir = new File(directoryPath);
            File[] listOfFiles = dir.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".txt")) {
                    Scanner scanner = new Scanner(listOfFiles[i]);

                    while (scanner.hasNextLine()) {
                        String data = scanner.nextLine();
                        // process data
                    }

                    scanner.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}