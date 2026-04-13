import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class java_21076_FileScanner_A03 {

    public static void main(String[] args) throws Exception {
        File startingDir = new File(".");
        Files.walkFileTree(startingDir.toPath(), new SimpleFileVisitor<>(), 8, null);
    }

    public static class FileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws Exception {
            if (file.toString().endsWith(".txt")) {
                try (Stream<String> lines = Files.lines(file)) {
                    lines.forEach(System.out::println);
                }
            }
            return FileVisitResult.CONTINUE;
        }
    }
}