import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_07277_FileScanner_A08 {
    public static void main(String[] args) {
        Path dir = Paths.get("path_to_directory");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(dir)) {
            for (Path path : dirs) {
                if (Files.isRegularFile(path)) {
                    BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    System.out.println(attrs.creationTime().toString() + " " + attrs.size() + " " + path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}