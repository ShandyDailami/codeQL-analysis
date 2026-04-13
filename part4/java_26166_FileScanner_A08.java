import java.io.File;
import java.util.Scanner;

public class java_26166_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a FileScanner instance
        FileScanner scanner = new FileScanner();

        // Ask for the directory to scan
        System.out.println("Please enter the directory to scan:");
        Scanner scannerInput = new Scanner(System.in);
        String directory = scannerInput.nextLine();

        // Scan the directory
        scanner.scanDirectory(new File(directory));

        // Close the scanner
        scanner.close();
    }
}

class FileScanner {
    public void scanDirectory(File directory) {
        // Loop through all the files in the directory
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                // If the file is a directory, scan it recursively
                scanDirectory(file);
            } else {
                // If the file is a regular file, print its name
                System.out.println("File: " + file.getName());
            }
       
            // Add your security-sensitive operations here
            // e.g., file integrity check
            // if (file.canRead()) {
            //     System.out.println("File " + file.getName() + " can be read.");
            // } else {
            //     System.out.println("File " + file.getName() + " cannot be read.");
            // }
        }
    }

    public void close() {
        // Implement closing logic here
    }
}