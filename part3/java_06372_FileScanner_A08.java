import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_06372_FileScanner_A08 {
    private static final String DIRECTORY_PATH = "/path/to/directory";

    public static void main(String[] args) {
        List<String> filePaths = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory path or 'q' to quit:");
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if ("q".equalsIgnoreCase(input)) {
                    break;
                }
                filePaths.add(input);
                System.out.println("Enter directory path or 'q' to quit:");
            }
        }

        filePaths.forEach(FileScanner::processDirectory);
    }

    private static void processDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                processLine(line);
                            }
                        } catch (Exception e) {
                            System.err.println("Error processing file: " + file.getPath());
                        }
                    } else if (file.isDirectory()) {
                        processDirectory(file.getPath());
                    }
                }
            }
        } else {
            System.err.println("Invalid directory: " + directoryPath);
        }
    }

    private static void processLine(String line) {
        // TODO: Implement security-sensitive operations related to A08_IntegrityFailure
    }
}