import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35784_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Path to the directory to scan
        String directoryPath = "path_to_directory";

        File directory = new File(directoryPath);

        // Use a try-with-resources statement to automatically close the scanner when we're done
        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String fileName = scanner.nextLine();
                System.out.println("File name: " + fileName);
            }
        }
    }
}