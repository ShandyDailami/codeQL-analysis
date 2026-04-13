import java.io.File;
import java.util.Scanner;

public class java_11740_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a Scanner for standard input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory path
        System.out.println("Enter a directory path:");
        String path = scanner.nextLine();

        // Create a File object for the specified path
        File directory = new File(path);

        // Use a recursive method to traverse all files in the directory
        traverseDirectory(directory);
    }

    private static void traverseDirectory(File directory) {
        // Get all files in the directory
        File[] files = directory.listFiles();

        if (files == null) {
            // There are no files in this directory
            return;
        }

        // Traverse all files
        for (File file : files) {
            if (file.isDirectory()) {
                // If the file is a directory, traverse it
                traverseDirectory(file);
            } else {
                // If the file is a regular file, print its name
                System.out.println(file.getName());
            }
        }
    }
}