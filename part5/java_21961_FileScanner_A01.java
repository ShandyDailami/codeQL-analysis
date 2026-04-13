import java.io.*;
import java.nio.file.*;

public class java_21961_FileScanner_A01 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path, "*.txt")) {
            for (Path dir : dirs) {
                File file = dir.toFile();
                if (file.exists()) {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}