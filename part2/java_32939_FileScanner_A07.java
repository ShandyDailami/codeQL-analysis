import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32939_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory we want to scan
        File directory = new File(".");

        // Create a Scanner object to read the directory
        Scanner scanner = new Scanner(directory.listFiles());

        // Loop through each file in the directory
        while (scanner.hasNext()) {
            String fileName = scanner.next();
            System.out.println(fileName);
        }

        // Close the Scanner
        scanner.close();
    }
}