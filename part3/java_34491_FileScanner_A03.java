import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_34491_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner object to read the file
        Scanner scanner = new Scanner(new File("file.txt"));

        // Use the Scanner object to read and print the file's contents
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        // Close the Scanner after use
        scanner.close();
    }
}