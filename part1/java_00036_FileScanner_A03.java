import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_00036_FileScanner_A03 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.*");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("."), "glob:*.java")) {
            for (Path path : dirs) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                if (attributes.isRegularFile()) {
                    long size = attributes.size();
                    String name = path.getFileName().toString();
                    System.out.println(name + ", Size: " + size);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}