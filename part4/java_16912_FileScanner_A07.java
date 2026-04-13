import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16912_FileScanner_A07 {

    private static final String SENSITIVE_DATA_PATTERN = "password";

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files found in the directory");
            return;
        }

        for (File file : files) {
            if (file.isFile() && isFileSafe(file)) {
                printSummary(file);
            }
        }
    }

    private static boolean isFileSafe(File file) {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(SENSITIVE_DATA_PATTERN)) {
                System.out.println("Suspicious activity detected in: " + file.getPath());
                return false;
            }
        }
        return true;
    }

    private static void printSummary(File file) {
        System.out.println("File: " + file.getPath());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("Last modified: " + file.lastModified());
    }
}