import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35529_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a File instance for the directory you want to scan
        File directory = new File("C:\\path\\to\\your\\directory");

        // Create a Scanner instance for the directory
        Scanner scanner = new Scanner(directory);

        // Loop through each file in the directory
        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            System.out.println(file.getName());
        }

        // Close the Scanner
        scanner.close();
    }
}