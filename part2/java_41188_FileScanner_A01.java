import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41188_FileScanner_A01 {

    public static void main(String[] args) {
        // Prompt user for directory
        System.out.print("Enter directory: ");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        // Initialize file scanner
        File directory = new File(directoryPath);

        // Check if directory exists
        if (!directory.exists()) {
            System.out.println("Directory not found!");
            return;
        }

        // Scan directory for files
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory!");
            return;
        }

        // Print contents of each file
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error reading file: " + file.getName());
                }
            }
        }
    }
}