import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_26093_FileScanner_A08 {
    public static void main(String[] args) {
        Path start = Paths.get(".");

        try (FileSystem fileSystem = start.getFileSystem()) {
            Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    long size = Files.size(file);
                    System.out.println(file.toString() + " : " + size);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}