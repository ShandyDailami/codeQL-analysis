import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29873_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with actual directory path
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}