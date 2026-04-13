import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01721_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with actual path
        File directory = new File(directoryPath);

        System.out.println("Entering directory: " + directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + e.getMessage());
        }
    }
}