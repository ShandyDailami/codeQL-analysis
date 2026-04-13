import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_23994_FileScanner_A01 {
    public static void main(String[] args) {
        Path directory = Paths.get("your_directory_path");
        try (FileScanner scanner = Files.newFileScanner(directory, new PathMatcher() {
            @Override
            public boolean matches(Path file, BasicFileAttributes attributes) throws IOException {
                // Return true if you want to scan all files, false if you want to scan only specific files.
                return true;
            }
        })) {
            scanner.forEach(path -> System.out.println(path.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}