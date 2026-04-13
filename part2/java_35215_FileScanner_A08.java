import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_35215_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        String directoryPath = args[0]; // Path to the directory to scan
        FileVisitor fileVisitor = new FileVisitor();
        File directory = new File(directoryPath);
        directory.walkFileTree(fileVisitor);
    }

    static class FileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file.toAbsolutePath());
            return FileVisitResult.CONTINUE;
        }
    }
}