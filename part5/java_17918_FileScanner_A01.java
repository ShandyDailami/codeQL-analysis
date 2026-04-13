import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17918_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            System.exit(0);
        }

        // Check if the directory is readable
        if (!directory.canRead()) {
            System.out.println("Insufficient permissions to read directory");
            System.exit(0);
        }

        // Scan the directory for files
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Check if the file is readable
                    if (!file.canRead()) {
                        System.out.println("Insufficient permissions to read file: " + file.getName());
                    } else {
                        // Create a Scanner for the file
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            if (line.contains("A01_BrokenAccessControl")) {
                                System.out.println("Found the keyword in file: " + file.getName());
                            }
                        }
                        fileScanner.close();
                    }
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}