import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_23613_FileScanner_A03 {
    public static void main(String[] args) throws Exception {
        String directory = System.getProperty("user.dir");
        Files.walkFileTree(Paths.get(directory), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".java")) {
                    System.out.println(file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}