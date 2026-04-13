import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32198_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {

        // Define the directory and file patterns
        String directoryPath = "src/main/resources/";
        String filePattern = "A*.txt";

        // Instantiate the FileScanner
        FileScanner fileScanner = new FileScanner(directoryPath, filePattern);

        // Use a Scanner to read the files
        while (fileScanner.hasNext()) {
            String filePath = fileScanner.next();
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Use the scanner to read and print the contents of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            scanner.close();
        }

        // Close the fileScanner
        fileScanner.close();
    }
}