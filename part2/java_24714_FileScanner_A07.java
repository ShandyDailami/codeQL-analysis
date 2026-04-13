import java.io.File;
import java.util.Scanner;

public class java_24714_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory path
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(dirPath);

        // Create a File object for the directory's parent
        File parentDir = dir.getParentFile();

        // Check if the directory exists
        if (dir.exists()) {
            // Check if the parent directory exists
            if (parentDir.exists()) {
                // Create a File object for the file to be scanned
                System.out.println("Enter the file name pattern:");
                String filePattern = scanner.nextLine();

                // Scan the directory for files that match the pattern
                File[] matchingFiles = parentDir.listFiles((File pathname) -> pathname.getName().matches(filePattern));

                // Print the names of the files that match the pattern
                if (matchingFiles != null) {
                    for (File file : matchingFiles) {
                        System.out.println(file.getName());
                    }
                } else {
                    System.out.println("No files found.");
                }
            } else {
                System.out.println("Parent directory does not exist.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        // Close the Scanner
        scanner.close();
    }
}