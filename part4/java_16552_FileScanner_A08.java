import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16552_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You can perform operations related to integrity failure here
                // For example, print the line to the console
                System.out.println(line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}