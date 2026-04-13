import java.nio.file.*;
import java.util.stream.*;

public class java_35006_FileScanner_A03 {

    // A list of known file extensions to search for
    private static final Set<String> KNOWN_EXTENSIONS = new HashSet<>(Arrays.asList(".txt", ".csv", ".json"));

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*." + KNOWN_EXTENSIONS);

        try (Stream<Path> paths = Files.find(Paths.get("."), Integer.MAX_VALUE, matcher)) {
            paths.forEach(file -> {
                if (Files.isRegularFile(file)) {
                    System.out.println("Found file: " + file.getFileName());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}