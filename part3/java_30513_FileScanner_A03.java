import java.io.File;
import java.util.Scanner;

public class java_30513_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a File object for the directory
        File directory = new File(".");

        // Use FileScanner to list all files in the directory
        Scanner scanner = new Scanner(directory.listFiles());

        // Print the names of all files in the directory
        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            System.out.println(file.getName());
        }

        // Close the Scanner
        scanner.close();
    }
}