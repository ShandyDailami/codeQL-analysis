import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_35295_FileScanner_A08 {

    private static final String DIRECTORY = "/path/to/your/directory";
    private static final String KEYWORD = "your_keyword";

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.walk(Paths.get(DIRECTORY))) {
            paths.filter(Files::isRegularFile)
                .forEach(FileScanner::readAndPrint);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readAndPrint(Path path) {
        if (Files.lines(path).anyMatch(line -> line.contains(KEYWORD))) {
            System.out.println("Found file: " + path.toString());
        }
    }
}