import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13703_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Request user for input
        System.out.println("Enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(path);

        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // Check if the directory is a file
        if (directory.isFile()) {
            System.out.println("Given path is not a directory!");
            return;
        }

        // Use FileScanner to list all files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}