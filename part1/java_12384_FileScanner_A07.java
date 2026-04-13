import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12384_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Ask user for directory and search pattern
        System.out.println("Enter the directory:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the search pattern:");
        String searchPattern = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // List all files in the directory that match the search pattern
        File[] files = directory.listFiles((dir, name) -> name.matches(searchPattern));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("No files found!");
        }
    }
}