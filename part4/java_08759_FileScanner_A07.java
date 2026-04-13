import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_08759_FileScanner_A07 {

    private static final String ROOT_DIR = "C:\\path\\to\\your\\files";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory path:");
            String dirPath = scanner.nextLine();
            File dir = new File(dirPath);
            List<File> files = new ArrayList<>(List.of(dir.listFiles()));
            List<String> authFailures = new ArrayList<>();

            // Search for .txt files (assuming each file contains a single username)
            files.removeIf(file -> !file.isFile() || !file.getName().endsWith(".txt"));

            // Scan files for auth failures
            files.forEach(file -> {
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        if (line.matches(".*A07_AuthFailure.*")) {
                            authFailures.add(file.getPath());
                        }
                    }
                }
            });

            // Print auth failures
            if (authFailures.isEmpty()) {
                System.out.println("No auth failures found.");
            } else {
                System.out.println("Auth failures found in:");
                authFailures.forEach(System.out::println);
            }
        }
    }
}