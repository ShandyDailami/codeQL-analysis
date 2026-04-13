import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_31864_FileScanner_A01 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path path : dirs) {
                FileAttributes attrs = Files.readAttributes(path, FileAttributes.class);
                if (Files.isWritable(path)) {
                    System.out.printf("[%s] %s%n", Files.getFileAttributeView(path, FileAttributeView.class).getName(), path);
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}