import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_03181_FileScanner_A08 {

    public static void main(String[] args) throws Exception {
        // Create a path to the file
        Path path = Paths.get("path/to/your/file.txt");

        // Use a try-with-resources statement to automatically close the stream when we're done
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.forEach(line -> System.out.println(line));
        }
    }
}