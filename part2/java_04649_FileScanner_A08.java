import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04649_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file"); // replace with your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // handle line here, e.g., print it
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}