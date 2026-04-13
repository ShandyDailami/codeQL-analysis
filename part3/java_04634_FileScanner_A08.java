import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04634_FileScanner_A08 {
    public static void main(String[] args) {
        // Creating a File object for the file you want to read
        File file = new File("path/to/file.txt");

        try {
            // Creating a Scanner object to read the file
            Scanner scanner = new Scanner(file);

            // Continuously reading lines from the file and printing them
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Closing the Scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}