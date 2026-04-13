import java.io.IOException;
import java.nio.file.*;

public class java_22881_FileScanner_A07 {

    public void scanFiles(Path start, String filter) throws IOException {
        Files.walkFileTree(start, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isReadable(file) && (filter == null || file.getFileName().toString().endsWith(filter))) {
                    System.out.println("Found file: " + file.toAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("."); // start at current directory
        new FileScanner().scanFiles(start, "txt"); // search for .txt files
    }
}