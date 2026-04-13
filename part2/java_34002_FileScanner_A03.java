import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34002_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input a directory
        System.out.println("Enter the directory:");
        String directoryPath = scanner.nextLine();

        // Verify if the directory exists
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // Scan the directory for files
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Could not read directory!");
        }

        // Close the scanner
        scanner.close();
    }
}