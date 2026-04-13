import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17138_FileScanner_A01 {
    public static void main(String[] args) {
        // Get the current user's home directory
        File homeDir = new File(System.getProperty("user.dir"));

        // Create a File object for the file we want to read
        File file = new File(homeDir, "test.txt");

        try (Scanner scanner = new Scanner(file)) {
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}