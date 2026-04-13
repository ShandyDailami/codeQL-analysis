import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_36750_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("path_to_your_file"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}