import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_38030_FileScanner_A01 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("./src/main/resources"), matcher)) {
            for (Path path : stream) {
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}