import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_21642_FileScanner_A01 {
    public static void main(String[] args) {
        // Directory to scan
        String dir = "/path/to/directory";

        try (Stream<Path> paths = Files.newDirectoryStream(Paths.get(dir))) {
            paths.forEach(path -> {
                if (Files.isRegularFile(path)) {
                    try {
                        File file = path.toFile();
                        System.out.printf("File: %s, Size: %d bytes%n", file.getName(), file.length());
                    } catch (IOException e) {
                        System.out.println("Failed to access file: " + path);
                    }
                } else if (Files.isDirectory(path)) {
                    System.out.printf("Directory: %s%n", path);
                }
            });
        } catch (IOException e) {
            System.out.println("Failed to access directory: " + dir);
        }
    }
}