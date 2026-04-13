import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_26077_FileScanner_A07 {
    public static void main(String[] args) {
        try (Stream<Path> paths = Files.find(Paths.get("/path/to/directory"), 10, (path, basicFileAttributes) -> true)) {
            paths.forEach(filePath -> {
                File file = filePath.toFile();
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}