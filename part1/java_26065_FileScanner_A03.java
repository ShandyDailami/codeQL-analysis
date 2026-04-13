import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_26065_FileScanner_A03 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        try (Stream<Path> paths = Files.walk(Paths.get("/path/to/dir"))) {
            paths.filter(matcher::matches)
                .map(FileSystems.getDefault()::getPath)
                .map(Main::isFileSecure)
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isFileSecure(Path path) {
        try (InputStream in = Files.newInputStream(path)) {
            return !in.readAllBytes().toString().contains("<secure content>");
        } catch (IOException e) {
            return false;
        }
    }
}