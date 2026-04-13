import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_03586_FileScanner_A03 {
    public static void main(String[] args) {
        Path start = Paths.get("path_to_directory");

        try (Stream<Path> paths = Files.walk(start)) {
            paths.forEach(file -> {
                if (Files.isRegularFile(file)) {
                    try {
                        System.out.printf("File: %s, Size: %d bytes%n", file.getFileName(), Files.size(file));
                    } catch (IOException e) {
                        System.err.printf("Error getting size of %s%n", file);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}