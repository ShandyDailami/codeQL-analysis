import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_38417_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("path_to_directory");
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isReadable(file)) {
                    System.out.println(file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static class SimpleFileVisitor<T extends BasicFileAttributes> extends ForwardingFileVisitor<T> {
        private java_38417_FileScanner_A07() {}

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (Files.isReadable(file)) {
                System.out.println(file.toString());
           
!
                }
            return FileVisitResult.CONTINUE;
        }
    }
}