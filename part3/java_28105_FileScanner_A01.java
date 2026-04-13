import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28105_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_file");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // perform security-sensitive operations related to A01_BrokenAccessControl
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}