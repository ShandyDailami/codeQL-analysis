import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_02883_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        // List all files in the directory
        File[] files = directory.listFiles();

        // Check if there are files in the directory
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Print file name and path
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("No files in the directory");
        }
    }
}