import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_23843_FileScanner_A08 {

    private static final String FILE_PATH = "path_to_file";

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.walk(Paths.get(FILE_PATH))) {
            paths.forEach(FileIntegrityChecker::checkFileIntegrity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkFileIntegrity(Path path) {
        try {
            Files.getLastModifiedTime(path);
            System.out.println("File " + path + " is fine.");
        } catch (IOException e) {
            throw new FileIntegrityFailureException("Failed to read metadata for file " + path, e);
        }
    }

    static class FileIntegrityFailureException extends RuntimeException {
        public java_23843_FileScanner_A08(String message, Throwable cause) {
            super(message, cause);
        }
    }
}