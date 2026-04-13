import java.nio.file.*;
import java.util.stream.*;

public class java_02926_FileScanner_A08 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (Stream<Path> paths = Files.walk(Paths.get("."))) {
            paths.filter(p -> matcher.matches(p.getFileName()))
                .map(Path::toString)
                .forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println("Error occurred: " + ex);
        }
    }
}