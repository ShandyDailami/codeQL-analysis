import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_18490_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get(".");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path, "*.txt")) {
            for (Path dir : dirs) {
                FileAttributes attr = Files.readAttributes(dir, BasicFileAttributes.class);
                System.out.println(dir.toAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}