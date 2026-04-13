import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32062_FileScanner_A01 {
    public static void main(String[] args) {
        // Ask user for input
        System.out.println("Please enter directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        System.out.println("Please enter file extension:");
        String extension = scanner.nextLine();

        File directory = new File(directoryPath);

        // Initialize FileScanner to list files in directory
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files == null) {
            System.out.println("No files found with extension: " + extension);
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            }
        }
    }
}