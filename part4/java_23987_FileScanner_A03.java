import java.nio.file.*;
import java.util.stream.*;

public class java_23987_FileScanner_A03 {

    public static void main(String[] args) {
        Path start = Paths.get(".");
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                System.out.println(file.getFileName());
                return FileVisitResult.CONTINUE;
            }
        };
        try (Stream<Path> paths = Files.walk(start, Integer.MAX_VALUE)) {
            paths.forEach(fileVisitor::visitFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}