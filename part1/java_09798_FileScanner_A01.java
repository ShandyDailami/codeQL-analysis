import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09798_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/security_sensitive_file.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}