import java.io.File;
import java.util.Scanner;

public class java_38901_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/AuthFailure.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("AuthFailure")) {
                    System.out.println("Line contains 'AuthFailure': " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}