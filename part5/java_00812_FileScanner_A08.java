import java.io.File;
import java.util.Scanner;

public class java_00812_FileScanner_A08 {
    public static void main(String[] args) {
        // Prompt user for directory path
        System.out.print("Enter directory path: ");
        Scanner scanner = new Scanner(System.in);
        String dirPath = scanner.nextLine();

        // Create File object and use it to scan directory
        File directory = new File(dirPath);

        // Get all files in the directory
        File[] files = directory.listFiles();

        // If there are no files, print a message
        if (files == null) {
            System.out.println("No files in the directory.");
            return;
        }

        // Print out each file's name
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}