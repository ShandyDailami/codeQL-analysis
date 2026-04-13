import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;

public class java_33440_FileScanner_A08 {
    private static class TextFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".txt")) {
                Files.readAllLines(file).stream().forEach(System.out::println);
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        Files.walk(Paths.get("/path/to/directory"))
            .filter(path -> Files.isRegularFile(path))
            .map(Paths.get("/path/to/directory"))
            .forEach(path -> {
                try {
                    Files.walk(path, TextFileVisitor::new)
                        .map(Path::toString)
                        .filter(FileScanner::isTextFile)
                        .map(path -> "