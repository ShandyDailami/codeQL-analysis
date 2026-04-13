import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_37584_FileScanner_A08 {
    private static final String DIRECTORY = "C:\\path_to_directory\\";
    private static final String FILE_EXTENSION = ".*\\.txt$";

    public static void main(String[] args) {
        SecurityChecker securityChecker = new SecurityChecker();
        securityChecker.checkFiles(DIRECTORY);
    }

    private void checkFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles(file -> file.isFile() && file.getName().matches(FILE_EXTENSION));

        if (files != null) {
            Arrays.stream(files).forEach(file -> checkFile(file));
        }
    }

    private void checkFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (isLineSensitive(line)) {
                    System.out.println("Security failure detected in file: " + file.getName());
                    // Handle the security failure here, e.g., remove the sensitive line
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred while processing file: " + file.getName());
            // Handle the exception here, e.g., remove the sensitive file
        }
    }

    // This method should be replaced with a more secure way of checking if a line is sensitive
    private boolean isLineSensitive(String line) {
        // Simple example of a check for a specific word in a line
        return line.contains("sensitive");
    }
}