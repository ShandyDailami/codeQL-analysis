import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_39683_FileScanner_A08 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (Stream<Path> paths = Files.walk(Paths.get("."))) {
            paths.forEach(path -> {
                if (matcher.matches(path.getFileName())) {
                    Path name = path.getFileName();
                    System.out.println("File Name: " + name);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}