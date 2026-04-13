import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17409_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // This creates a new File object for the directory you want to scan.
            File directory = new File(".");

            // This starts a scan for all files in the directory.
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (!file.isDirectory()) {
                        // This code will only be executed if the file has a readable ".txt" extension.
                        if (file.getName().endsWith(".txt")) {
                            // This code will attempt to open and read the file.
                            Scanner fileScanner = new Scanner(file);

                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                // This line intentionally left blank.
                                // You can add your security-sensitive operation here.
                            }

                            fileScanner.close();
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}