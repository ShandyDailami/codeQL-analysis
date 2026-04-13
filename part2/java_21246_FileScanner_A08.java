import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_21246_FileScanner_A08 {
    private static final String DIR_PATH = "path_to_directory";
    private static final String FILE_CONTENT_STRING = "A08_IntegrityFailure";

    public static void main(String[] args) {
        Path dir = Paths.get(DIR_PATH);

        try (Stream<Path> paths = Files.walk(dir)) {
            paths.forEach(FileScanner::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(FileScanner::checkContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkContent(String content) {
        if (content.contains(FILE_CONTENT_STRING)) {
            System.out.println("Content contains the string: " + FILE_CONTENT_STRING);
        }
    }
}