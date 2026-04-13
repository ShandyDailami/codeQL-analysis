import java.io.File;
import java.util.Scanner;
import java.util.FileScanner;

public class java_25787_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object for the directory
        File directory = new File(".");

        // Create a Scanner object for the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a file name
        System.out.println("Enter the file name:");
        String fileName = scanner.next();

        // Create a FileScanner object for the directory
        FileScanner fileScanner = new FileScanner(directory, fileName);

        // Use the FileScanner to list all the files in the directory
        while (fileScanner.hasNext()) {
            System.out.println(fileScanner.next());
        }

        // Close the FileScanner
        fileScanner.close();
    }
}