import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_14457_FileScanner_A07 {

    public static class FileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            // Print file name
            System.out.println(file.getFileName());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            // Handle I/O exception
            System.err.println(file + ": " + exc);
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) {
        String dirPath = args.length == 0 ? "." : args[0];

        try {
            Files.walkFileTree(Paths.get(dirPath), new FileVisitor());
        } catch (IOException e) {
            System.err.println("Failed to walk the directory tree.");
        }
    }
}