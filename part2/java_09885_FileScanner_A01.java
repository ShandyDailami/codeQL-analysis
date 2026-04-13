import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09885_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // Creating file scanner
            File file = new File("path/to/file.txt");
            Scanner fileScanner = new Scanner(file);

            // Read and print file content
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            // Close file scanner
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}