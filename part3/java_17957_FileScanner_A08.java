import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17957_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the current directory
        File currentDir = new File(".");

        // Use a try-with-resources statement to automatically close the scanner
        // when it's no longer needed
        try (Scanner scanner = new Scanner(currentDir)) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                // Print the name of the file
                System.out.println(file.getName());
            }
        }
    }
}