import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01870_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            // Start by creating a File object that represents the directory we want to scan
            File directory = new File("your_directory_path_here");
            
            // Use a Scanner to read the contents of the directory
            Scanner scanner = new Scanner(directory);
            
            // Use a loop to go through each file in the directory
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                File file = new File(fileName);
                
                // If the file is a directory, go inside it
                if (file.isDirectory()) {
                    System.out.println("Found directory: " + fileName);
                    goIntoDirectory(file);
                } else {
                    // Otherwise, do something with the file
                    System.out.println("Found file: " + fileName);
                    handleFile(file);
                }
            }
            
            // Close the scanner when we're done
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Directory does not exist: " + e.getMessage());
        }
    }

    private static void goIntoDirectory(File directory) {
        try {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println("Found directory inside: " + file.getName());
                        goIntoDirectory(file);
                    } else {
                        System.out.println("Found file inside: " + file.getName());
                        handleFile(file);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to list files in directory: " + e.getMessage());
        }
    }

    private static void handleFile(File file) {
        // Add your security-sensitive operations here
        // For example, to check if the file is executable, you can use:
        if (file.canExecute()) {
            System.out.println("File is executable: " + file.getName());
        } else {
            System.out.println("File is not executable: " + file.getName());
        }
    }
}