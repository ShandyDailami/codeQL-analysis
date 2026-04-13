import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_36018_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.java")) {
            for (Path path : dirs) {
                BasicFileAttributes attrs;
                try {
                    attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    System.out.println(path + " is a file and its attributes are " + attrs);
                } catch (IOException e) {
                    System.out.println("Couldn't read attributes for " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("Couldn't list directory contents");
        }
    }
}