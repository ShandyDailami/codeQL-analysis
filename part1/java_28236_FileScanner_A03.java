import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_28236_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                if (Files.isReadable(file)) {
                    System.out.println("Reading file: " + file.toString());
                    Files.readAllLines(file).forEach(System.out::println);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}