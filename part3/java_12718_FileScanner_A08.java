import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_12718_FileScanner_A08 {

    public static void main(String[] args) throws Exception {
        Path startingDirectory = Paths.get(".").toAbsolutePath();
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(startingDirectory, fileVisitor);
    }

}