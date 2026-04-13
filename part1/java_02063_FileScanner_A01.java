import java.nio.file.*;
import java.util.stream.*;

public class java_02063_FileScanner_A01 {
    private PathMatcher<Path> matcher;

    public java_02063_FileScanner_A01(Path root) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");
        findFiles(root).forEach(System.out::println);
    }

    private Stream<Path> findFiles(Path root) {
        try (Stream<Path> stream = Files.walk(root)) {
            return stream.filter(Files::isRegularFile);
        } catch (IOException e) {
            return Stream.empty();
        }
    }

    public boolean accept(Path path) {
        return matcher.matches(path.getFileName());
    }

    public static void main(String[] args) {
        new FileScanner(Paths.get("/path/to/your/project"));
    }
}