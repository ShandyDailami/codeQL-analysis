import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12325_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Ask for file path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String path = scanner.nextLine();

        // Check if path is valid
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        // Open file and scan for integrity failures
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("A08_IntegrityFailure")) {
                    System.out.println("Integrity failure detected in line: " + line);
                }
            }
        }
    }
}