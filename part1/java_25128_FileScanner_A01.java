import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_25128_FileScanner_A01 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/path/to/directory"), matcher)) {
            for (Path path : stream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println(path.toString());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}