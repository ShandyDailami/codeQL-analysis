import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;
import java.util.stream.Stream;

public class java_23941_FileScanner_A07 {
    private static final PathMatcher<Path> DEFAULT_PATH_MATCHER = FileSystems.getDefault().getPathMatcher("glob:**/*.java");

    public static void main(String[] args) throws IOException {
        Path startPath = Paths.get(".").toAbsolutePath();

        try (Stream<Path> paths = Files.find(startPath, Integer.MAX_VALUE,
                (path, attributes) -> DEFAULT_PATH_MATCHER.matches(path.getFileName()),
                DirectoryStream.ReadOption.FOLLOW_LINKS)) {

            for (Path path : paths) {
                if (!path.toFile().isDirectory()) {
                    iterateFiles(path);
                }
            }
        }
    }

    private static void iterateFiles(Path path) {
        try (Stream<Path> subpaths = Files.find(path, Integer.MAX_VALUE,
                (p, a) -> p.toFile().isFile() && !Files.isDirectory(p) && !Files.isReadable(p),
                DirectoryStream.ReadOption.FOLLOW_LINKS)) {

            for (Path subpath : subpaths) {
                System.out.println("File found: " + subpath);
            }
        } catch (IOException e) {
            System.err.println("Error processing file: " + path);
        }
    }
}