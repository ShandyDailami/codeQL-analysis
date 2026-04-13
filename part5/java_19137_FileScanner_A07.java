import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19137_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            try {
                Scanner scanner = new Scanner(directory);
                while (scanner.hasNextLine()) {
                    String filePath = scanner.nextLine();
                    File file = new File(filePath);
                    if (file.exists() && !file.isDirectory()) {
                        // Code to handle file
                        // e.g., check for file integrity
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}