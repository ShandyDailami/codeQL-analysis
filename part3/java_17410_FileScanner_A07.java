import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_17410_FileScanner_A07 {
    private static final String DIRECTORY = "C:\\Users\\Public\\Documents";
    private static final String FILE_PATTERN = "A07_*.txt";

    public static void main(String[] args) {
        File dir = new File(DIRECTORY);
        List<File> files = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Enumerate files in the directory
        File[] listOfFiles = dir.listFiles((dir2, name) -> name.matches(FILE_PATTERN));
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                files.add(file);
            }
        }

        // Scan files for auth failures
        for (File file : files) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    // TODO: Implement logic to detect auth failures
                    // e.g. Detect specific words like 'failed', 'denied', etc.
                    // For now, just print the line
                    System.out.println(line);
                }
            }
        }

        // Close scanner
        scanner.close();
    }
}