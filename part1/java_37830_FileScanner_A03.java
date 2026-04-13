import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

class java_37830_FileScanner_A03 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path startPath = Paths.get("."); // This could be a directory to scan, or a single file to scan.

        Files.walkFileTree(startPath, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    Files.lines(file).filter(line -> line.contains("injection")).forEach(System.out::println);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}