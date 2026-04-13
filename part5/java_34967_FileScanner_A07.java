import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_34967_FileScanner_A07 {
    public static void main(String[] args) {
        // Get the directory path from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        // Create a File object and a FilenameFilter
        File directory = new File(directoryPath);
        FilenameFilter filter = (dir, name) -> name.endsWith(".txt");

        // Print all .txt files in the directory
        File[] txtFiles = directory.listFiles(filter);
        if (txtFiles != null) {
            Arrays.stream(txtFiles).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No .txt files found in the directory.");
        }

        // Close the scanner
        scanner.close();
    }
}