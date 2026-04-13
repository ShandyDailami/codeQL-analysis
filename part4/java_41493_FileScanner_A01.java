import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41493_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new File object for the directory
        File directory = new File(".");

        // Use a FileFilter to only get files in the directory
        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        // If no such file exists, end the program
        if (listOfFiles == null) {
            System.out.println("No .txt files in directory.");
            System.exit(0);
        }

        // Loop through all the files
        for (File file : listOfFiles) {
            try (Scanner scanner = new Scanner(file)) {
                // Print each line of the file
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getName());
            }
        }
    }
}