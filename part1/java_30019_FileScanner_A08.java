import java.nio.file.*;
import java.util.regex.*;

public class java_30019_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the path to the directory and the pattern
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        Path directory = Paths.get("path/to/directory");

        // Scan the directory
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(directory, matcher)) {
            for (Path path : paths) {
                // Print out the name of each file
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}