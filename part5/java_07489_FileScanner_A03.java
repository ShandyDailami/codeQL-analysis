import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_07489_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory
        System.out.println("Enter a directory:");
        String dir = scanner.nextLine();

        // Create a File object and set it to the user's input
        File file = new File(dir);

        // Check if the directory exists
        if (file.exists()) {
            // If the directory exists, list all files in it
            System.out.println("Files in directory: " + file.getPath());
            String[] files = file.list();
            Arrays.sort(files); // sort files

            // Print each file
            for (String name : files) {
                System.out.println(name);
            }
        } else {
            // If the directory does not exist, print a message
            System.out.println("Directory does not exist.");
        }

        // Close the scanner
        scanner.close();
    }
}