import java.io.File;
import java.util.Scanner;

public class java_15968_FileScanner_A03 {
    public static void main(String[] args) {
        // Ask user for directory path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object
        File file = new File(directoryPath);

        // Check if directory exists
        if (file.exists() && file.isDirectory()) {
            System.out.println("Scanning directory: " + directoryPath);

            // Use File's listFiles method to get a list of files in the directory
            File[] files = file.listFiles();

            // Check if there are files
            if (files != null) {
                for (File f : files) {
                    // If the file is a directory, recursively scan it
                    if (f.isDirectory()) {
                        scanDirectory(f);
                    } else {
                        // If the file is a file, print its name
                        System.out.println("Found file: " + f.getName());
                   
                        // Assume that file contains the text 'A03_Injection'
                        if (f.getName().contains("A03_Injection")) {
                            System.out.println("Found injection attack!");
                        }
                    }
                }
            } else {
                System.out.println("No files found in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }

    private static void scanDirectory(File directory) {
        // Recursively scan a directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    scanDirectory(f);
                } else {
                    // If the file is a file, print its name
                    System.out.println("Found file: " + f.getName());

                    // Assume that file contains the text 'A03_Injection'
                    if (f.getName().contains("A03_Injection")) {
                        System.out.println("Found injection attack!");
                    }
                }
            }
        }
    }
}