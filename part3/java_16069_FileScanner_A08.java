import java.nio.file.*;
import java.util.stream.*;

public class java_16069_FileScanner_A08 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");

        try (Stream<Path> paths = Files.walk(Paths.get("/path/to/your/dir"))) {
            paths.filter(p -> matcher.matches(p.getFileName()))
                .forEach(Main::printPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPath(Path path) {
        System.out.println(path.toString());
    }
}