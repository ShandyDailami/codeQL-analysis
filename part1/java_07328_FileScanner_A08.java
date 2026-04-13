import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.Duration;
import java.util.stream.Stream;

public class java_07328_FileScanner_A08 {

    public static void main(String[] args) throws IOException, InterruptedException {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        Duration lastModifiedDuration = Duration.ofSeconds(30);

        Files.walk(Paths.get(directoryPath))
            .filter(Files::isRegularFile)
            .filter(Main::hasBeenModifiedSinceLastTime)
            .forEach(Main::printFileDetails);
    }

    private static boolean hasBeenModifiedSinceLastTime(Path path) {
        try {
            return Files.getLastModifiedTime(path).compareTo(
                Files.getLastModifiedTime(path).minus(lastModifiedDuration)) >= 0;
        } catch (IOException e) {
            return false;
        }
    }

    private static void printFileDetails(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Failed to read file: " + path);
        }
    }
}