import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32237_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("path_to_file"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you should implement the logic to handle lines according to Broken Access Control
                // For simplicity, let's just print the line
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}