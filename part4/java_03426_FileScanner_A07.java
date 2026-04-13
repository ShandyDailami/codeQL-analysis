import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03426_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // Replace with your directory path
        String fileName = "file.txt"; // Replace with your file name

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Secure operation here: Echos the line to console.
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}