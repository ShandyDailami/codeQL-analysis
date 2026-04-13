import java.io.File;
import java.util.Scanner;

public class java_02127_FileScanner_A08 {
    public static void main(String[] args) {
        // Step 1: Create a Scanner object to read command line arguments
        Scanner scanner = new Scanner(System.in);

        // Step 2: Prompt the user to enter a directory
        System.out.println("Please enter a directory:");
        String directory = scanner.nextLine();

        // Step 3: Create a File object to represent the directory
        File dir = new File(directory);

        // Step 4: Use the File.listFiles() method to get an array of all files in the directory
        File[] files = dir.listFiles();

        // Step 5: Check each file to see if it has a readable attribute
        for (File file : files) {
            if (file.canRead()) {
                System.out.println("File: " + file.getName());
            }
        }

        // Step 6: Close the Scanner object
        scanner.close();
    }
}