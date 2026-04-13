import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_40277_FileScanner_A03 {
    private static final PathMatcher<Path> FILE_MATCHER = FileSystems.getDefault().getPathMatcher("glob:*.txt");

    public static void main(String... args) throws Exception {
        Path startingDirectory = Paths.get(".");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "*.txt");

        for (Path path : directoryStream) {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            if (attributes.isRegularFile() && FILE_MATCHER.matches(path.getFileName())) {
                System.out.println(path.getFileName());
            }
        }
    }
}