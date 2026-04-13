import java.nio.file.*;
import java.util.*;

public class java_25226_FileScanner_A03 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (Stream<Path> paths = Files.walk(Paths.get("/path/to/directory"))) {
            paths.filter(matcher::matches).map(Main::readFile).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return reader.readLine();
        } catch (IOException e) {
            return "Error reading file: " + path.toString();
        }
    }
}