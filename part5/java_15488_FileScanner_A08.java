import java.nio.file.*;
import java.util.stream.*;

public class java_15488_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (Stream<Path> paths = Files.walk(startingDirectory)) {
            paths
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .map(File::new)
                .map(FileInputStream::new)
                .map(SecureFileScanner::isIntegrityFailure)
                .filter(Boolean.TRUE::equals)
                .forEach(file -> System.out.println(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isIntegrityFailure(File file) {
        // Here is a dummy check for integrity failure.
        // Please replace this with your own checks for integrity failure.
        return file.canRead();
    }
}