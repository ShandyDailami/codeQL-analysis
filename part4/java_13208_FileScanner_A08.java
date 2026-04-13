import java.io.File;
import java.util.Scanner;

public class java_13208_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("sample.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a placeholder for a security-sensitive operation,
                // where we print the line to console for demonstration purposes.
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}