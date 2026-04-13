import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_33035_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.println("Please enter a directory:");
        String dirPath = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(dirPath);

        // Check if the directory exists
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // Get all the files in the directory
        File[] files = dir.listFiles();

        // Check if there are files in the directory
        if (files == null) {
            System.out.println("No files in directory");
            return;
        }

        // Print out all the files and directories in the directory
        Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
    }
}