import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36156_FileScanner_A08 {
    private static final String DIRECTORY = "src/main/java";

    public static void main(String[] args) {
        File file = new File(DIRECTORY);
        findFiles(file);
    }

    private static void findFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findFiles(file);
                } else {
                    processFile(file);
                }
            }
        }
    }

    private static void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A08_IntegrityFailure")) {
                    System.out.println("Security Violation Found in File: " + file.getPath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}