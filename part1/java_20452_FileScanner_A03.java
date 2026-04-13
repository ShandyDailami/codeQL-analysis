import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_20452_FileScanner_A03 {

    // Pattern to detect SQL Injection attempts
    private static final Pattern SQL_INJECTION_PATTERN = Pattern.compile("(?i)sql\\b");

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Set your directory path here
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isFileSafeToRead(file)) {
                    readFileSafe(file);
                }
            }
        }
    }

    private static boolean isFileSafeToRead(File file) {
        return !SQL_INJECTION_PATTERN.matcher(file.getName()).find();
    }

    private static void readFileSafe(File file) {
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Continue with your logic to handle the line, e.g., print it
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}