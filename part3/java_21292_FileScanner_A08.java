import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_21292_FileScanner_A08 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path path : stream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                if (attributes.isRegularFile()) {
                    System.out.println(path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}