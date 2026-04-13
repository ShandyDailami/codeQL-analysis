import java.io.*;
import java.nio.file.*;

public class java_22417_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Specify the directory path
        Path directory = Paths.get(directoryPath);

        try (FileScanner scanner = Files.newFileScanner(directory)) {
            System.out.println("Scanning directories for files...");

            // Scan the directories
            scanner.forEach(path -> {
                if (Files.isRegularFile(path)) {
                    System.out.println("Found file: " + path.toString());
                } else if (Files.isDirectory(path)) {
                    System.out.println("Found directory: " + path.toString());
                }
            });
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}