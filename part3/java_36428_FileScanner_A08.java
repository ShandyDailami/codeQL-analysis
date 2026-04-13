import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_36428_FileScanner_A08 {
    public static void main(String[] args) {
        Path path = Paths.get("path_to_directory");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path filePath : directoryStream) {
                if (Files.isRegularFile(filePath)) {
                    BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
                    long time = attrs.creationTime().toMillis();
                    long lastModifiedTime = attrs.lastModifiedTime().toMillis();
                    long lastAccessedTime = attrs.lastAccessTime().toMillis();

                    System.out.println("File: " + filePath);
                    System.out.println("Creation Time: " + time);
                    System.out.println("Last Modified Time: " + lastModifiedTime);
                    System.out.println("Last Accessed Time: " + lastAccessedTime);
                } else if (Files.isDirectory(filePath)) {
                    System.out.println("Directory: " + filePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}