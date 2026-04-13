import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_24642_FileScanner_A01 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("."); // get the current directory
        BasicFileAttributes attrs;

        // scan the directory
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}