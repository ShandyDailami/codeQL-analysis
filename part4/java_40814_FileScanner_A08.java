import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40814_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Path to directory
        String directoryPath = "/path/to/directory";

        // Create a File object
        File directory = new File(directoryPath);

        // Use the Scanner class to open the directory
        Scanner scanner = new Scanner(directory);

        // Read the files in the directory
        while (scanner.hasNextLine()) {
            String fileName = scanner.nextLine();
            File file = new File(directoryPath + "/" + fileName);

            // Check if the file is a regular file (not a directory or a device file)
            if (file.isFile()) {
                System.out.println("File name: " + file.getName());

                // Use a Scanner to read the file content
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    System.out.println("Content: " + fileScanner.nextLine());
                }
                fileScanner.close();
            }
        }
        scanner.close();
    }
}