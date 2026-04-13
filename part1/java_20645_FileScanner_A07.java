import java.io.File;
import java.util.Scanner;

public class java_20645_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a scanner to read the user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the directory path
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object and set it to the directory path
        File directory = new File(directoryPath);

        // Scan the directory and print out all files and directories
        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    } else {
                        System.out.println(file.getName() + "/");
                    }
                }
            } else {
                System.out.println("Directory does not exist.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        // Close the scanner
        scanner.close();
    }
}