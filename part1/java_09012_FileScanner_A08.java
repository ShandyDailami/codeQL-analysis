import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_09012_FileScanner_A08 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src"), matcher)) {
            for (Path path : stream) {
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}