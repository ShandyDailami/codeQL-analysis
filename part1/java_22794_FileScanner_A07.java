import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_22794_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt,log}");

        try (DirectoryStream<Path> directories = Files.newDirectoryStream(Paths.get("."), "dir")) {
            for (Path dir : directories) {
                try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, matcher)) {
                    for (Path file : files) {
                        FileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                        System.out.println(file.toString());
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}