import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_25402_FileScanner_A08 {
    private static class Finder extends SimpleFileVisitor<Path> {
        private String extension;

        public java_25402_FileScanner_A08(String extension) {
            this.extension = extension;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(extension)) {
                System.out.println(file.toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        String directory = "path/to/directory";
        String extension = ".txt";

        Files.walkFileTree(Paths.get(directory), new Finder(extension));
    }
}