import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12904_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a new File object for the directory to scan
        File directory = new File(".");

        // Use try-with-resources to automatically close the scanner when it's no longer needed
        try (Scanner scanner = new Scanner(directory.listFiles())) {
            // Use the scanner to list all the files in the directory
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                System.out.println(fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}