import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_02576_FileScanner_A07 {
    private static final String DIRECTORY = "path_to_your_directory";

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get(DIRECTORY), new MyFileVisitor());
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("File: " + file.toString());
            byte[] bytes = Files.readAllBytes(file);
            System.out.println("File content: " + new String(bytes));
            return FileVisitResult.CONTINUE;
        }
    }
}