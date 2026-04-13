import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_14462_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".").toAbsolutePath().normalize(); // change to your directory
        try (Stream<Path> paths = Files.walk(startingDirectory)) {
            paths
                .filter(Files::isRegularFile)
                .filter(Main::isSecuritySensitive)
                .forEach(Main::readAndPrintFileContent);
        }
    }

    private static boolean isSecuritySensitive(Path path) {
        // implement your own logic to check if a file is security sensitive
        // for example, if a file contains sensitive information or is in a directory
        // with restricted access
        return false;
    }

    private static void readAndPrintFileContent(Path path) {
        try {
            byte[] bytes = Files.readAllBytes(path);
            String content = new String(bytes, StandardCharsets.UTF_8);
            System.out.printf("Content of %s:\n%s\n\n", path, content);
        } catch (IOException e) {
            System.out.printf("Error reading %s\n", path);
        }
    }
}