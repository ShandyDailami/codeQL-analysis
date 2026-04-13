import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27109_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Define the directory to start scanning
        File startDir = new File(".");

        // Create a scanner to read files and directories
        Scanner scanner = new Scanner(System.in);

        // Ask the user for a directory to start scanning
        System.out.println("Enter the directory to start scanning:");
        String directory = scanner.nextLine();

        // Create a new File object for the directory
        File dir = new File(directory);

        // List all files and directories in the directory and its subdirectories
        listFiles(dir, startDir);
    }

    private static void listFiles(File dir, File startDir) {
        // Get all files and directories in the directory
        File[] files = dir.listFiles();

        // Check if there are files and directories
        if (files != null) {
            for (File file : files) {
                // If it's a file and it's not the start directory, print the name
                if (file.isFile() && !file.getAbsolutePath().startsWith(startDir.getAbsolutePath())) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    // If it's a directory, recursively call listFiles
                    listFiles(file, startDir);
                }
            }
        }
    }
}