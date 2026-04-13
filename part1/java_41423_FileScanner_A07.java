import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_41423_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get("."); // The current directory

        try (FileSystem fs = path.getFileSystem()) {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String name = file.getFileName().toString();
                    if (name.endsWith(".txt")) {
                        System.out.println(name);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}