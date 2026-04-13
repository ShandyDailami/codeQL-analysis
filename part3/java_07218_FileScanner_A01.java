import java.nio.file.*;
import java.io.*;

public class java_07218_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get("C:\\"); // Change this to the directory you want to scan
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "*.*")) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    System.out.println("File: " + path.toString());
                } else if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path.toString());
                }
            }
        }
    }
}