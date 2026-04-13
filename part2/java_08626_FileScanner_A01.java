import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_08626_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath().normalize();
        String fileName = "targetFile";
        try (Stream<Path> paths = Files.walk(startingDirectory)) {
            paths.forEach(path -> {
                try {
                    Files.isSameFile(path, startingDirectory.resolve(fileName));
                    System.out.println(path.toString());
                } catch (UnsupportedOperationException | AccessDeniedException e) {
                    System.out.println("Access denied for " + path);
                } catch (IOException e) {
                    System.out.println("Error accessing " + path);
                }
            });
        } catch (IOException e) {
            System.out.println("Error walking the directory tree");
        }
    }
}