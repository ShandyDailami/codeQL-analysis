import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_17864_FileScanner_A01 {
    public static void main(String[] args) {
        Path path = Paths.get("."); // Use current directory
        try (FileSystem fs = path.getFileSystem()) {
            Files.walkFileTree(path, new SimpleFileVisitor<>(), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SimpleFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toString());
        return FileVisitResult.CONTINUE;
    }
}