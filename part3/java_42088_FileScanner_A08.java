import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_42088_FileScanner_A08 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.txt");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."))) {
            for (Path path : stream) {
                if (matcher.matches(path.getFileName())) {
                    FileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    if (attrs.isReadable()) {
                        System.out.println(path.toString());
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}