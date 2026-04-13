import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_20538_FileScanner_A01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDirectory = Paths.get("src/main/java");
        FileSystem fs = startingDirectory.getFileSystem();
        try (Stream<Path> paths = fs.find(startingDirectory,
                (p, attrs) -> attrs.isRegularFile() && p.toString().endsWith(".java"))) {
            paths.forEach(System.out::println);
        }
    }
}