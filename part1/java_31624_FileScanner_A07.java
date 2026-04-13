import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31624_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Define the directory path
        String directoryPath = "/path/to/your/directory";

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Use FileScanner to list all files in the directory
        FileScanner fileScanner = new FileScanner(directory);

        // Use a Scanner to count the number of files
        Scanner scanner = new Scanner(System.in);
        int fileCount = 0;
        while (fileScanner.hasNext()) {
            fileCount++;
            fileScanner.nextFile();
        }
        scanner.close();

        // Output the number of files
        System.out.println("Number of files in directory: " + fileCount);
    }
}