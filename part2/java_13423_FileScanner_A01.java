import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13423_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new Scanner that will read from the file named "brokenAccess.txt"
        Scanner fileScanner = new Scanner(new File("brokenAccess.txt"));

        // Read and print each line in the file
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        // Close the scanner
        fileScanner.close();
    }
}