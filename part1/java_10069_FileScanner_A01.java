import java.io.*;
import java.nio.file.*;
import java.security.Permission;
import java.security.CodeSource;

public class java_10069_FileScanner_A01 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get("src");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.java")) {
            for (Path path : dirs) {
                File file = path.toFile();
                if (!file.canRead()) {
                    System.out.println("Cannot read file: " + file.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            System.out.println("Error accessing file system: " + e.getMessage());
        }
    }
}