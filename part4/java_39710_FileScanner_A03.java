import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_39710_FileScanner_A03 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt,log}");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path path : stream) {
                FileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println(path + " (" + attributes.size() + ")");
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}