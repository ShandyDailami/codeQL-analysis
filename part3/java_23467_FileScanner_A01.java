import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23467_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // This is the file we want to scan
        File file = new File("target.txt");

        // We'll use a scanner to read the file's content
        Scanner scanner = new Scanner(file);

        // Now, we'll print out each line of the file's content
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // After we're done with the scanner, we'll close it
        scanner.close();
    }
}