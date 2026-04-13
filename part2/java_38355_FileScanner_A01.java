import java.nio.file.*;
import java.util.stream.*;

public class java_38355_FileScanner_A01 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.txt");
        try (Stream<Path> paths = Files.walk(Paths.get("."))) {
            paths.filter(Files::isRegularFile)
                .filter(path -> matcher.matches(path.getFileName()))
                .forEach(file -> {
                    System.out.println("Reading file: " + file.getFileName());
                    try (Stream<String> lines = Files.lines(file)) {
                        lines.forEach(line -> System.out.println(line));
                    }
                });
        }
    }

}