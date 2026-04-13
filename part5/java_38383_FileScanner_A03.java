import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_38383_FileScanner_A03 {
    public static void main(String[] args) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("."))) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path);
                } else {
                    System.out.println("File: " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}