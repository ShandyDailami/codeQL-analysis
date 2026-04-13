import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02114_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file");
            Scanner scanner = new Scanner(file);

            // Read file content
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}