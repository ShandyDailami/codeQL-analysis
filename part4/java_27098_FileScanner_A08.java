import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_27098_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        // define the path to the file
        Path path = Paths.get("path_to_your_file.txt");

        // use try-with-resources to automatically close the stream
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            // print each line
            lines.forEach(line -> System.out.println(line));
        }
    }
}