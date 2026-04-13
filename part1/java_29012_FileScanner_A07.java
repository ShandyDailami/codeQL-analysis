import java.io.*;
import java.nio.file.*;

public class java_29012_FileScanner_A07 {
    public static void main(String[] args) {
        Path dir = Paths.get("."); // The current directory
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if (Files.isRegularFile(path)) {
                    System.out.println("Regular file: " + path);
                } else if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path);
                } else {
                    System.out.println("Other: " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to process directory: " + e.getMessage());
        }
    }
}