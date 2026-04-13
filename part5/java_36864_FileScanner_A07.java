import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_36864_FileScanner_A07 {
    public static void main(String[] args) {
        // Ask for a directory path
        System.out.println("Enter a directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        // Ask for a file extension
        System.out.println("Enter a file extension:");
        String extension = scanner.nextLine();

        // Scan the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        // Filter out files without read permission
        for (File file : files) {
            try (FileReader reader = new FileReader(file)) {
                // If the file is readable, print its name
                System.out.println(file.getName());
            } catch (FileNotFoundException e) {
                // If the file does not exist, do nothing
                System.out.println("File not found: " + file.getName());
            } catch (IOException e) {
                // If there's an error reading the file, print the error message
                System.out.println("Error reading file: " + file.getName() + ". " + e.getMessage());
            }
        }
    }
}