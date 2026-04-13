import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_24676_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path directory = Paths.get("path_to_directory");

        try (Stream<Path> paths = Files.walk(directory)) {
            paths.forEach(file -> {
                if (Files.isRegularFile(file)) {
                    try (Stream<String> lines = Files.lines(file)) {
                        lines.forEach(System.out::println);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}