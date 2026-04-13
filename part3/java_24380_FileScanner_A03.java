import java.io.File;
import java.util.Scanner;

public class java_24380_FileScanner_A03 {
    private static final String DIR_PATH = "src/main/java";
    private static final String FILE_EXTENSION = "java";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory path:");
            String directoryPath = scanner.nextLine();

            File dir = new File(directoryPath);

            if (!dir.exists() || !dir.isDirectory()) {
                System.out.println("Invalid directory path.");
                return;
            }

            File[] files = dir.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

            if (files == null) {
                System.out.println("No files found in the directory.");
                return;
            }

            for (File file : files) {
                scanFile(file);
            }
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Insert your security-sensitive operations here.
                // For instance, detecting suspicious code patterns.
                // ...
            }
        } catch (Exception e) {
            System.out.println("Error scanning file: " + file.getPath());
        }
    }
}