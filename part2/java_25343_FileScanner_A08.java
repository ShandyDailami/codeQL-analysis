import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25343_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Print the name and size of each file
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File name: " + file.getName());
                System.out.println("File size: " + file.length() + " bytes");
                System.out.println();
            }
        }
    }
}