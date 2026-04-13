import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15481_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        int maxSize = 1024; // Maximum size of files to scan in bytes
        String directoryPath = "path_to_directory"; // Replace with actual path

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> new File(dir, name).length() > maxSize);

        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                int lineNumber = 1;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("Line " + lineNumber + ": " + line);
                    lineNumber++;
                }
                scanner.close();
            }
        } else {
            System.out.println("No files found in directory: " + directoryPath);
        }
    }
}