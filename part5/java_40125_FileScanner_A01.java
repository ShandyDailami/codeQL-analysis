import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_40125_FileScanner_A01 {
    private static final String BASE_DIRECTORY = "C:\\"; // Replace with your base directory

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        scanner.close();

        File baseDirectory = new File(BASE_DIRECTORY);
        File[] directoryFiles = baseDirectory.listFiles();

        if (directoryFiles != null) {
            Arrays.stream(directoryFiles)
                    .filter(file -> file.isDirectory())
                    .filter(file -> file.getName().equals(directoryPath))
                    .forEach(file -> scanDirectory(file, directoryPath));
        } else {
            System.out.println("Base directory does not exist or is not accessible.");
        }
    }

    private static void scanDirectory(File directory, String directoryPath) {
        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.stream(files)
                    .filter(file -> file.isFile())
                    .filter(file -> isFileAccessible(file, directoryPath))
                    .forEach(file -> printFileDetails(file));
        }
    }

    private static boolean isFileAccessible(File file, String directoryPath) {
        // Implement security-sensitive operations related to A01_BrokenAccessControl
        // For simplicity, this method will always return true
        return true;
    }

    private static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getAbsolutePath());
        System.out.println("---------------------------");
    }
}