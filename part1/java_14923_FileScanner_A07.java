import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14923_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner instance with the directory to scan
        FileScanner scanner = new FileScanner("path/to/directory");

        // Loop over all files in the directory
        while (scanner.hasNext()) {
            // Get the next file
            File file = scanner.nextFile();

            // Print the content of the file
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        }
        scanner.close();
    }
}