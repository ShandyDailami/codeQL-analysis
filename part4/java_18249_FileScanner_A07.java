import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_18249_FileScanner_A07 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDirectory = Paths.get("src");

        // Start the process
        Files.walk(startingDirectory, 1)
            .filter(path -> Files.isRegularFile(path))
            .forEach(Main::printFileInfo);
    }

    private static void printFileInfo(Path path) {
        if (path.toString().endsWith(".java")) {
            FileSystem fs = FileSystems.newFileSystem(path, null);
            try (Stream<Path> files = Files.walk(path)) {
                files.forEach(Main::printFilePath);
            }
        }
    }

    private static void printFilePath(Path path) {
        System.out.println(path.toString());
    }
}