import java.nio.file.*;
import java.util.regex.Pattern;

public class java_30792_FileScanner_A07 {
    private static final Pattern FILE_EXTENSION_PATTERN = Pattern.compile(".*\\.(txt)$");

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        try (Stream<Path> stream = Files.walk(Paths.get("."))) {
            stream.forEach(path -> {
                if (matcher.matches(path)) {
                    System.out.println(path.toString());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}