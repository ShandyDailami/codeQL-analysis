import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31480_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/access_control_file.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Potentially dangerous operation: Reading file contents
                System.out.println("Attempting to read file: " + line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}