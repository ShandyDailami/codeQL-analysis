import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39035_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the integrity failure mode (1-Read files, 2-Delete files, 3-Write files):");
            int mode = scanner.nextInt();

            switch (mode) {
                case 1:
                    scanFiles(directory);
                    break;
                case 2:
                    deleteFiles(directory);
                    break;
                case 3:
                    writeFiles(directory);
                    break;
                default:
                    System.out.println("Invalid mode.");
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void scanFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }

    private static void deleteFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (!file.delete()) {
                        System.out.println("Failed to delete file: " + file.getName());
                    }
                }
            }
        }
    }

    private static void writeFiles(File directory) {
        // The following code will not work as it will delete all files in the directory
        // Instead, it will create a new file and write the content to it.
        // If you want to write content to an existing file, you should use FileWriter instead.
        // For the purpose of this example, we are not implementing this functionality.
    }
}