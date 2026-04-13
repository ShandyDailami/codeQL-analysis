import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_14141_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("path_to_your_file.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                if (line.contains("AuthFailure")) {
                    System.out.println(line);
                }
            });
        }
    }
}