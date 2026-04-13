import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_28376_FileScanner_A03 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/path/to/directory"), matcher)) {
            for (Path path : stream) {
                FileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println(path.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}