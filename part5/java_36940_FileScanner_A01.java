import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_36940_FileScanner_A01 {

    public static void main(String[] args) {

        // Create a File object for the file to be read
        File file = new File("file.txt");

        // Try to open the file
        try {
            Scanner scanner = new Scanner(file);

            // Read each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}