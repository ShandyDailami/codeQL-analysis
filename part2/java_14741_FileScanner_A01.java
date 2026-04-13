import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_14741_FileScanner_A01 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("src/main/java"))) {
            for (Path path : directoryStream) {
                if (matcher.matches(path.getFileName())) {
                    FileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    System.out.println(path.getFileName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}