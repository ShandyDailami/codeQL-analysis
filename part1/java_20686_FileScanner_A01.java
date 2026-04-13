import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_20686_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file");
            Scanner scanner = new Scanner(file);

            // Start reading file without any access control
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Stop reading file after printing out sensitive data
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}