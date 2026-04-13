import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_24127_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        Files.walkFileTree(Paths.get("."), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    System.out.println("File: " + file.getFileName());
                    printFileContents(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void printFileContents(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            lines.forEach(System.out::println);
        }
    }
}