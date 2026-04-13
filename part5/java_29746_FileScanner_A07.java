import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_29746_FileScanner_A07 {

    private static final String SECRET_KEY = "someSecretKey";
    private static final String AUTH_FAILURE_FILE_NAME = ".auth_failure";

    public static void main(String[] args) {
        scanFiles(Paths.get("/path/to/files"));
    }

    public static void scanFiles(Path path) {
        try (Stream<Path> paths = Files.list(path)) {
            paths.filter(AuthFailureScanner::isFileAuthFailure)
                .forEach(AuthFailureScanner::handleAuthFailure);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isFileAuthFailure(Path path) {
        return Files.isSameFile(path, getAuthFailureFile()) &&
            Files.readAllLines(path).contains(SECRET_KEY);
    }

    private static File getAuthFailureFile() {
        return new File(Paths.get("")
            .resolve(AUTH_FAILURE_FILE_NAME)
            .toString());
    }

    private static void handleAuthFailure(Path path) {
        System.out.println("AuthFailure detected in file: " + path.toString());
    }
}