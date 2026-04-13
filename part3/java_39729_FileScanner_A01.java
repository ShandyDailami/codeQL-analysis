import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39729_FileScanner_A01 {
    private static final String SENSITIVE_WORDS = "sensitive";

    public static void main(String[] args) {
        File file = new File("path_to_your_file.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(SENSITIVE_WORDS)) {
                    System.out.println("Detected sensitive word in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}