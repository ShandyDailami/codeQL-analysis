import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_08379_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(startingDirectory)) {
            for (Path path : dirStream) {
                if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    printDirectory(path, "  ");
                } else {
                    System.out.println(path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDirectory(Path dir, String indent) {
        if (dir == null) {
            return;
        }
        System.out.println(indent + dir.getFileName());
        try (DirectoryStream<Path> subDirs = Files.newDirectoryStream(dir,
                (d, e) -> e.isDirectory())) {
            for (Path p : subDirs) {
                printDirectory(p, indent + "  ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}