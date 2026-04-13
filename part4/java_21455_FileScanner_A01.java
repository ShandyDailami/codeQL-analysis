import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_21455_FileScanner_A01 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("<directory_path>");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }

}