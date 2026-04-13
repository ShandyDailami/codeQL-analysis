import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34929_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String filePath = scanner.nextLine();
                File file = new File(filePath);

                if (file.isFile()) {
                    // handle file
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    // handle directory
                    System.out.println("Directory: " + file.getName());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + e.getMessage());
        }
    }
}