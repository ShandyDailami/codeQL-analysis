import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_19560_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/path/to/directory"))) {
            for (Path path : stream) {
                if (matcher.matches(path.getFileName())) {
                    BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    System.out.println(path.getFileName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}