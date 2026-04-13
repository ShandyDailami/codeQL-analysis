import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29940_FileScanner_A07 {
    public static void main(String[] args) {
        String filePath = "path_to_your_file"; // replace with your file path

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains("authFailure")) {
                    System.out.println("File contains the word 'authFailure', which is a security-sensitive operation. Please handle this appropriately.");
                    return; // stop the program
                }

                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}