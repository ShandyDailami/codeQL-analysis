import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27593_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist or is not a directory.");
            return;
        }

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String filePath = scanner.nextLine();
                File file = new File(filePath);
                if (file.exists() && file.isFile()) {
                    System.out.println("File: " + file.getPath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}