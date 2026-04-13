import java.io.File;
import java.nio.file.*;

public class java_18138_FileScanner_A07 {

    private static final String FILE_PATTERN = ".*test.java";

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + FILE_PATTERN);

        try (DirectoryStream<Path> files = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path path : files) {
                File file = path.toFile();
                if (file.exists()) {
                    System.out.println("File name: " + file.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}