import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_17832_FileScanner_A07 {
    public static void main(String[] args) {
        // Prompt user for directory
        System.out.print("Enter directory path: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        File directory = new File(path);

        // Check if directory exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        // Get all files in directory
        File[] files = directory.listFiles();

        // Check if files exist
        if (files == null) {
            System.out.println("No files in directory!");
            return;
        }

        // Print all files
        Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
    }
}