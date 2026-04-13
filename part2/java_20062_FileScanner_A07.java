import java.io.File;
import java.util.Scanner;

public class java_20062_FileScanner_A07 {
    public static void main(String[] args) {
        // Specify the directory to start scanning
        File startDir = new File(".");

        // Create a scanner to read files in the directory
        try (Scanner scanner = new Scanner(startDir)) {
            while (scanner.hasNext()) {
                // Get the next file name
                String fileName = scanner.next();

                // Create a File object for the current file
                File currentFile = new File(fileName);

                // Check if the current file is a directory
                if (currentFile.isDirectory()) {
                    // If it is, get the list of files in the directory and start scanning there
                    try (Scanner dirScanner = new Scanner(currentFile)) {
                        while (dirScanner.hasNext()) {
                            String dirFileName = dirScanner.next();
                            File dirFile = new File(dirFileName);

                            // Check if the file is a "AuthFailure.txt" file
                            if (dirFile.getName().equals("AuthFailure.txt")) {
                                // If it is, stop scanning
                                break;
                            }

                            // Print the file name to the console
                            System.out.println("Found AuthFailure.txt in " + dirFile.getPath());
                        }
                    }
                } else {
                    // If it's not a directory, check if it's a "AuthFailure.txt" file
                    if (currentFile.getName().equals("AuthFailure.txt")) {
                        // If it is, stop scanning
                        break;
                    }

                    // Print the file name to the console
                    System.out.println("Found AuthFailure.txt in " + currentFile.getPath());
                }
            }
        } catch (Exception e) {
            // Handle any exceptions that might occur when reading the directory
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}