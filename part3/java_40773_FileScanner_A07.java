import java.nio.file.*;
import java.io.*;

public class java_40773_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path path : dirStream) {
                File file = path.toFile();
                if (file.canRead() && !file.isDirectory()) {
                    System.out.println("File: " + file.getAbsolutePath() + " has read access.");
                } else {
                    System.out.println("File: " + file.getAbsolutePath() + " does not have read access.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}