import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_32575_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // replace with your directory path
        String[] excludedFilePatterns = {"excluded_file1", "excluded_file2"}; // replace with your excluded file patterns

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isFile() && !isExcluded(file, excludedFilePatterns)) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line); // replace with your processing logic
                        }
                    }
                }
            });
        }
    }

    private static boolean isExcluded(File file, String[] excludedFilePatterns) {
        String fileName = file.getName();
        return Arrays.stream(excludedFilePatterns).anyMatch(fileName::matches);
    }
}