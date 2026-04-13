import java.io.File;
import java.util.Scanner;

public class java_05114_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        printFilesInDirectory(directoryPath);
    }

    public static void printFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        // Make sure the directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // Get all files from the directory
        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files found");
            return;
        }

        // Print the content of each file
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        System.out.println("Content: " + scanner.nextLine());
                   
                    }
                }
            }
        }
    }
}