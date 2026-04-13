import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_40031_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.println("Please enter a directory:");
        String directoryPath = scanner.next();

        // Create a new File object
        File directory = new File(directoryPath);

        // List all the files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(Main::printFileInfo);
        } else {
            System.out.println("No files in the directory!");
        }

        // Close the scanner
        scanner.close();
    }

    private static void printFileInfo(File file) {
        if (file.isFile()) {
            System.out.println("File: " + file.getName());
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("File size: " + file.length() + " bytes");
            System.out.println("-----------------------");
        } else if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("-----------------------");
        }
    }
}