import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_17891_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileExtension = ".txt";

        Path path = Paths.get(directoryPath);

        try (Stream<Path> stream = Files.walk(path)) {
            Stream<Path> matches = stream
                    .filter(p -> p.toString().endsWith(fileExtension))
                    .filter(p -> isSecuritySensitiveFile(p));

            for (Path match : matches.toArray()) {
                System.out.println("Found security sensitive file: " + match.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isSecuritySensitiveFile(Path path) {
        // Implement your own security check here. For simplicity, we assume a file is security-sensitive if its name contains 'auth' or 'fail'.
        return path.getFileName().toString().contains("auth") || path.getFileName().toString().contains("fail");
    }
}