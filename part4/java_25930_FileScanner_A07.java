import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_25930_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path path : dirs) {
                FileVisitResult result;
                if ((result = Files.probeContentType(path)) != null) {
                    System.out.printf("Content type of %s is %s%n", path, result);
                } else {
                    System.out.printf("Could not determine content type of %s%n", path);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}