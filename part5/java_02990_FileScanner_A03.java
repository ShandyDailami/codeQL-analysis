import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_02990_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".");

        try (Stream<Path> stream = Files.newDirectoryStream(startingDirectory)) {
            stream.forEach(file -> {
                if (Files.isRegularFile(file)) {
                    System.out.println(file.getFileName());
                }
            });
        }
    }
}