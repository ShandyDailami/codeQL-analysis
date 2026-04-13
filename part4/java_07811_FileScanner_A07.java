import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardVisitResult;

public class java_07811_FileScanner_A07 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        new FileVisitor().visit(new File(directory));
    }

    private static class FileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file.toFile().getAbsolutePath());
            return StandardVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return StandardVisitResult.CONTINUE;
        }
    }
}