import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14024_FileScanner_A07 {
    public static void main(String[] args) {
        // Specify the directory and file to scan
        String directoryPath = "/path/to/directory";
        String filePath = "/path/to/file";

        try {
            // Open the file and scan it
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Iterate over each line in the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}