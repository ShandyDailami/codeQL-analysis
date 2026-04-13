import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25361_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        // The file to be scanned
        File file = new File("path_to_your_file");

        // Create a scanner to read the file
        Scanner scanner = new Scanner(file);

        // Use the scanner to read and print the file content
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        // Close the scanner
        scanner.close();
    }
}