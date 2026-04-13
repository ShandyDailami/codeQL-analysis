import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_32386_FileScanner_A03 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path start = Paths.get(".").toAbsolutePath();
        search(start, "*.java");
    }

    private static void search(Path path, String pattern) throws IOException, InterruptedException {
        try (Stream<Path> walk = Files.walk(path)) {
            walk.filter(Files::isRegularFile)
                .filter(p -> p.toString().matches(pattern))
                .forEach(System.out::println);
        }
    }
}