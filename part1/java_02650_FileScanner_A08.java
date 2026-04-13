import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02650_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // The line contains potentially sensitive information, so now we just print it out.
                System.out.println(line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}