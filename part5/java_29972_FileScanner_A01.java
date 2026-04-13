import java.io.File;
import java.util.Scanner;

public class java_29972_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new file scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.println("Enter a directory:");
        String directory = scanner.nextLine();

        // Create a new file object
        File file = new File(directory);

        // Check if the directory exists
        if (file.exists()) {
            // Iterate through all the files in the directory
            for (File f : file.listFiles()) {
                // Print the name of each file
                System.out.println(f.getName());
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        // Close the scanner
        scanner.close();
    }
}