import java.io.IOException;
import java.nio.file.*;

public class java_03262_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        Path source = Paths.get("src");
        Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("File: " + file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }

}