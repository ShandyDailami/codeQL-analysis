import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38942_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/data.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add your security-sensitive operations here, like integrity check.
                // For now, let's just print out the line.
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}