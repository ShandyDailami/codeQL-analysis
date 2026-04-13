import java.io.File;
import java.util.Scanner;

public class java_10248_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a new File object for the current directory
        File file = new File(".");

        // Create a new Scanner object to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Ask the user for permission to continue
        System.out.println("Do you want to continue? (y/n)");
        char response = scanner.next().charAt(0);

        // If the user wants to continue, list all files and directories in the current directory
        if (response == 'y') {
            listFilesAndDirectories(file, 0);
        }

        // Close the scanner
        scanner.close();
    }

    private static void listFilesAndDirectories(File file, int indent) {
        // Print the file's name with spaces for indentation
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println(file.getName());

        // If the file is a directory, list all files and directories in it
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                listFilesAndDirectories(subFile, indent + 1);
            }
        }
    }
}