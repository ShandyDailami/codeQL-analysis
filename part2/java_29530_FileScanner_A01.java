import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_29530_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".").toAbsolutePath();

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingPath, "*.{txt,log}")) {
            for (Path path : dirs) {
                FileAttributes attributes = Files.readAttributes(path, FileAttributes.class);
                if (attributes.isDirectory()) {
                    System.out.println("Directory: " + path);
                } else {
                    System.out.println("File: " + path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}