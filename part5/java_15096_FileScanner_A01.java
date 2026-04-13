import java.nio.file.*;
import java.util.regex.Pattern;

public class java_15096_FileScanner_A01 {
    private static final Pattern FILE_PATTERN = Pattern.compile("^.+\\.java$");

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:src/main/java/*.java");
        try (DirectoryStream<Path> directories = FileSystems.getDefault().getDirectoryStream(Path.of("src/main/java"), "glob:**/*.java")) {
            for (Path path : directories) {
                if (matcher.matches(path)) {
                    System.out.println(path.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}