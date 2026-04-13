import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_00359_FileScanner_A08 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path path : stream) {
                FileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                if (attributes.size() > 500) {
                    System.out.println(path.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}