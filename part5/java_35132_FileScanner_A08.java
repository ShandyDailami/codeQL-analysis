import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35132_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        String extension = ".*\\.txt$";  // Replace with your file extension

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.matches(extension));

        if (files != null) {
            for (File file : files) {
                readFile(file);
            }
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations here.
                // For example, check the file for integrity.
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}