import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22684_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Prompt user for directory path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object
        File directory = new File(directoryPath);

        // Prompt user for file type
        System.out.println("Enter the file type (e.g., .txt):");
        String fileType = scanner.nextLine();

        // Search for files of the specified type
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileType));

        // Print out the names of the files
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found of type: " + fileType);
        }

        scanner.close();
    }
}