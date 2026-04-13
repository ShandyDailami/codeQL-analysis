import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35430_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {

        // Create a File instance to represent a file in the file system
        File file = new File("example.txt");

        // Create a Scanner instance to read from the file
        Scanner scanner = new Scanner(file);

        // Use the scanner to read and print each line of the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Close the scanner when finished
        scanner.close();
    }
}