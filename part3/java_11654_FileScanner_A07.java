import java.io.File;
import java.util.Scanner;

public class java_11654_FileScanner_A07 {
    public static void main(String[] args) {
        // Set the directory path
        String directoryPath = "/path/to/directory";

        // Get the directory
        File directory = new File(directoryPath);

        // Create a FileScanner to scan files in the directory
        FileScanner fileScanner = new FileScanner(directory);

        // Use the FileScanner to read files in the directory
        while (fileScanner.hasNext()) {
            File file = fileScanner.nextFile();
            Scanner scanner = new Scanner(file);

            // Print each line of the file
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        }

        fileScanner.close();
    }
}