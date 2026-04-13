import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_06345_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {

        // Create a File object for the file to be scanned.
        File file = new File("sample.txt");

        // Use a Scanner to read the file.
        Scanner scanner = new Scanner(file);

        // Use a while loop to read and print the file.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Close the Scanner.
        scanner.close();
    }
}