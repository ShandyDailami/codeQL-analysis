import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_28777_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path path : dirs) {
                FileAttributes attrs = Files.readAttributes(path, FileAttributes.class);
                long size = attrs.size();
                System.out.println("File size: " + size);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}