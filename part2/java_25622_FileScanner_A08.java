import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25622_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "C:\\path\\to\\your\\directory";
        File directory = new File(directoryPath);

        // Use a try-with-resources statement to automatically close the scanner when we're done with it
        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                System.out.println("File name: " + fileName);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The specified file was not found.");
        }
    }
}