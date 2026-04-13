import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03434_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the current directory
        File directory = new File(".");

        // Use a Scanner to get files in the directory
        Scanner scanner = new Scanner(directory.listFiles());

        // Print all the files in the directory
        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}