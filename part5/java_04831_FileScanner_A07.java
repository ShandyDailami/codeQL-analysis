import java.io.File;
import java.util.Scanner;

public class java_04831_FileScanner_A07 {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory path
        System.out.print("Enter a directory path: ");
        String directoryPath = scanner.nextLine();

        // Create a File object and set it to the directory path
        File directory = new File(directoryPath);

        // If the directory exists, print out the names of its files
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        // Close the scanner
        scanner.close();
    }
}