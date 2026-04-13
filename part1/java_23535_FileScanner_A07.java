import java.io.File;
import java.util.Scanner;

public class java_23535_FileScanner_A07 {

    private static final String DIRECTORY = "path_to_directory"; // replace with your directory
    private static final String FILE_EXTENSION = "log";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        // Check if directory exists and is readable
        if (directory.exists() && directory.canRead()) {
            File[] logFiles = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

            // If there are log files, process them
            if (logFiles != null) {
                for (File logFile : logFiles) {
                    processFile(logFile);
                }
            }
        } else {
            System.out.println("Directory does not exist or is not readable.");
        }
    }

    private static void processFile(File logFile) {
        try (Scanner scanner = new Scanner(logFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Failed to authenticate")) {
                    // You can handle this case as per your requirements. For example, you may want to alert the user or take some action.
                    System.out.println("Failed to authenticate: " + logFile.getPath());
                }
            }
        } catch (Exception e) {
            System.out.println("Error processing file: " + logFile.getPath());
        }
    }
}