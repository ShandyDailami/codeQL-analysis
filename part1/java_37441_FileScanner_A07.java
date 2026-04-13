import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class java_37441_FileScanner_A07 {

    private static final String DIRECTORY_PATH = "/path/to/directory";  // replace with your directory path

    public static void main(String[] args) {
        scanDirectory(new File(DIRECTORY_PATH));
    }

    private static void scanDirectory(File directory) {
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file);
            } else {
                printFileInfo(file);
            }
        }
    }

    private static void printFileInfo(File file) {
        // This method prints the file name and path
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());

        // Security-sensitive operation: Check if file is readable
        if (!file.canRead()) {
            System.out.println("File is not readable, skipping...");
            return;
        }

        // Security-sensitive operation: Try to read the file
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println("File content: " + scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}