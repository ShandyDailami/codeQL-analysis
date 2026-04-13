import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20611_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner for the file
        Scanner scanner = new Scanner(new File("src/main/resources/example.txt"));

        // Loop through all files in the directory
        while (scanner.hasNextLine()) {
            String fileName = scanner.nextLine();
            System.out.println("File name: " + fileName);
        }

        // Close the scanner
        scanner.close();
    }
}