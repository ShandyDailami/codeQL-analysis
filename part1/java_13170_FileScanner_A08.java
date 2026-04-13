import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_13170_FileScanner_A08 {

    public static void main(String[] args) {
        Path path = Paths.get(".");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path, "*")) {
            for (Path dir : dirs) {
                checkDirectoryIntegrity(dir);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void checkDirectoryIntegrity(Path dir) {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, "*")) {
            for (Path file : files) {
                FileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                if (Files.isHidden(file)) {
                    System.out.println("File '" + file + "' is hidden");
                }
                if (attrs.creationTime().compareTo(attrs.lastModifiedTime()) < 0) {
                    System.out.println("File '" + file + "' was last modified before it was created");
                }
                if (Files.size(file) == 0) {
                    System.out.println("File '" + file + "' is empty");
                }
                if (Files.isSameFile(file, dir)) {
                    System.out.println("File '" + file + "' is the same as its parent directory");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}