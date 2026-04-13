import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12840_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory"; // replace with your directory path

        File directory = new File(directoryPath);

        // Use try-with-resources to automatically close the scanner after usage
        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                String filePath = scanner.next();
                System.out.println("File path: " + filePath);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}