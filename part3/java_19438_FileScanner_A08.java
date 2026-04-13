import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19438_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with actual directory path
        String fileName = "target_file.txt"; // Replace with actual file name

        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(fileName)) {
                    System.out.println("File found: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}