import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_01063_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the directory path
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object and set it to the directory path
        File directory = new File(directoryPath);

        // Create a list to store the file names
        List<String> fileNames = new ArrayList<>();

        // List all files in the directory
        listFiles(directory, fileNames);

        // Print all file names
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    private static void listFiles(File directory, List<String> fileNames) {
        // Get all files in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                // Check if the file is a directory
                if (file.isDirectory()) {
                    // Recursively list files in the directory
                    listFiles(file, fileNames);
                } else {
                    // Add the file name to the list
                    fileNames.add(file.getName());
                }
            }
        }
    }
}