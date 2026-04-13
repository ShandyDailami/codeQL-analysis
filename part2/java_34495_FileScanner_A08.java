import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34495_FileScanner_A08 {
    public static void main(String[] args) {
        // Specify the directory path
        String directoryPath = "/path/to/your/directory";

        // Get the directory
        File directory = new File(directoryPath);

        // If the directory does not exist, print a message and exit
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // Iterate over all files in the directory
        for (File file : directory.listFiles()) {
            // If the file is a directory, print a message and skip it
            if (file.isDirectory()) {
                System.out.println("Skipping directory: " + file.getName());
                continue;
            }

            // If the file is a file and not a directory, print its name
            System.out.println("File: " + file.getName());
        }
    }
}