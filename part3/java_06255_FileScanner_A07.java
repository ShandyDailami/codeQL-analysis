import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_06255_FileScanner_A07 {

    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        Path path = Paths.get(dirPath);

        try (Stream<Path> paths = Files.walk(path)) {
            paths.filter(Files::isRegularFile)
                .forEach(AuthFailureScanner::checkFilePermission);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkFilePermission(Path file) {
        try {
            Files.isWritable(file, LinkOption.NOFOLLOW_LINKS);
            System.out.println("File " + file + " is writable");
        } catch (IOException e) {
            System.out.println("Unable to check permission for file " + file);
        }
    }
}