import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class java_35276_FileScanner_A07 {

    public static void main(String[] args) {
        Path startingDir = FileSystems.getDefault().getPath(".");

        Files.walkFileTree(startingDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String name = file.toString();
                if (name.endsWith(".java")) {
                    System.out.println("Found java file: " + name);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}