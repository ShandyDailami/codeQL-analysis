import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21782_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/file");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a security risk, as it allows any user to read the file.
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}