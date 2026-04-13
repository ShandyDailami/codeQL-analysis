import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_17074_FileScanner_A08 {

    public static class FileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            // This method should not be called for files in the directory, as we only want directories.
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitLink(Path link, BasicFileAttributes attrs) {
            // This method should not be called for symbolic links.
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            // Handle access errors.
            System.out.printf("Failed to access file: %s%n", file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            // This is called after all files have been visited.
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) {
        try (FileSystems fs = FileSystems.newFileSystem(Path.of("."), null)) {
            fs.getPath(".", new FileVisitor()).iterator().forEach(A08_IntegrityFailure::printPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printPath(Path path) {
        System.out.println(path.toString());
    }
}