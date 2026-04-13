import java.io.File;
import java.util.Scanner;

public class java_35462_FileScanner_A08 {
    public static void main(String[] args) {
        // Check if directory was provided
        if (args.length == 0) {
            System.out.println("Please provide a directory to scan");
            return;
        }

        // Get the directory to scan
        File dir = new File(args[0]);

        // Check if directory exists
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // Scan the directory for files
        File[] listOfFiles = dir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // Print the name of the file
                    System.out.println("File: " + file.getName());
                }
            }
        }
    }
}