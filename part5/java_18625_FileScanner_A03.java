import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_18625_FileScanner_A03 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path path : dirs) {
                BasicFileAttributes attrs;
                try {
                    attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    System.out.println(path.toString() + " (access time: " + attrs.creationTime() + ", last modified: " + attrs.lastModifiedTime() + ", size: " + attrs.size() + ")");
                } catch (IOException e) {
                    System.out.println("Failed to read attributes for " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to open directory stream");
        }
    }
}