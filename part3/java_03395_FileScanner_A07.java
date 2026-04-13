import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_03395_FileScanner_A07 {

    public static void main(String[] args) {

        // Create a File object for the file we want to scan
        File file = new File("C:\\path\\to\\file.txt");

        try {
            // Create a Scanner object for the file
            Scanner scanner = new Scanner(file);

            // Use a while loop to read and print the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner when done
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}