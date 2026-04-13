import java.io.File;
import java.util.Scanner;

public class java_35822_FileScanner_A01 {
    public static void main(String[] args) {
        // Get the current directory
        File currentDir = new File(".");

        // Use a FileFilter to only look at directories and files with .txt extension
        File[] listOfFiles = currentDir.listFiles((dir, name) -> name.endsWith(".txt"));

        // If there are no .txt files in the current directory, print a message
        if (listOfFiles == null) {
            System.out.println("No .txt files in the current directory.");
        } else {
            // Otherwise, print out each .txt file in the current directory
            for (File file : listOfFiles) {
                System.out.println("File: " + file.getName());
           
                try (Scanner scanner = new Scanner(file)) {
                    // Use a try-with-resources to automatically close the scanner when done
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Line: " + line);
                    }
                }

                System.out.println();
            }
        }
    }
}