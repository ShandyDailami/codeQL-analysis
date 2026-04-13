import java.io.File;
import java.util.Scanner;

public class java_07871_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path/to/your/file.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("password")) {
                    System.out.println("Found line with 'password': " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}