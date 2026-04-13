import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_25214_FileScanner_A07 {
    public static void main(String[] args) throws IOException, SecurityException {
        Path path = Paths.get("<path-to-directory>");

        try (Stream<Path> paths = Files.walk(path)) {
            paths.forEach(file -> {
                if (Files.isWritable(file)) {
                    System.out.println(file.toAbsolutePath());
                }
            });
        }
    }
}