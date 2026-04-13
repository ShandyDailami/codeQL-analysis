import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30587_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Define the directory where the security-sensitive files are located
        File directory = new File("/path/to/directory");

        // Create a FileScanner to scan the directory
        FileScanner scanner = new FileScanner(directory);

        // Scan all files in the directory
        while (scanner.hasNext()) {
            File file = scanner.nextFile();

            // Define the security-sensitive operation here, e.g. reading a file
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Do something with the line (e.g. print it)
                System.out.println(line);
            }
            fileScanner.close();
        }

        // Close the scanner
        scanner.close();
    }
}