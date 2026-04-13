import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_07715_FileScanner_A08 {
    private static final String DIR_PATH = "/path/to/dir"; // replace this with your directory path

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path!");
            return;
        }

        List<String> integrityFailureFiles = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter file integrity failure names (comma separated):");
            String line = scanner.nextLine();

            for (String fileName : line.split(",")) {
                File file = new File(dir, fileName);
                if (!file.exists() || file.isDirectory()) {
                    System.out.println("Invalid file name: " + fileName);
                    continue;
                }

                // assuming that the file has integrity failure
                if (isFileIntegrityFailure(file)) {
                    integrityFailureFiles.add(fileName);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nFiles with integrity failures:");
        for (String fileName : integrityFailureFiles) {
            System.out.println(fileName);
        }
    }

    private static boolean isFileIntegrityFailure(File file) {
        // Implement your own logic to check if a file is integrity failure here
        // This is just a placeholder, replace it with your actual implementation
        return false;
    }
}