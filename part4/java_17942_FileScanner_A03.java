import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_17942_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".");

        // Set the filter to only consider .txt files
        FileVisitOption[] options = { FileVisitOption.FOLLOW_LINKS };

        // Perform the directory scan
        try (Stream<Path> paths = Files.newServerDirectoryStream(startingDirectory, "*.txt")) {
            paths.forEach(file -> {
                System.out.println(file.toString());
            });
        }
    }
}