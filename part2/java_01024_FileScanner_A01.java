import java.io.*;
import java.nio.file.*;

public class java_01024_FileScanner_A01 {
    public static void main(String[] args) {
        Path directory = Paths.get("./src/main/java");
        try (DirectoryStream<Path> files = Files.newDirectoryStream(directory)) {
            for (Path path : files) {
                if (Files.isReadable(path)) {
                    System.out.println("Accessible file: " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}