import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20833_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Creating a new file instance
        File file = new File("src/main/resources/test.txt");

        // Creating a new scanner instance
        Scanner scanner = new Scanner(file);

        // Using a while loop to read the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Closing the scanner
        scanner.close();
    }
}