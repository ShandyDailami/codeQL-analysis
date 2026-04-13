import java.io.File;
import java.util.Scanner;

public class java_28502_FileScanner_A07 {
    public static void main(String[] args) {
        // Get the current directory
        File file = new File(".");

        // Create a new scanner for reading files
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}