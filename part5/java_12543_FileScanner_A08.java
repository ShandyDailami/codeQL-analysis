import java.io.File;
import java.util.Scanner;

public class java_12543_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a scanner to read input from the command line
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a directory
        System.out.print("Enter a directory: ");
        String directory = input.next();

        // Create a File object to represent the directory
        File dir = new File(directory);

        // Check if the directory exists
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // List all files in the directory
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            }
        }
    }
}