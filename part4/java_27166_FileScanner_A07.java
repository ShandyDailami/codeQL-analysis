import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_27166_FileScanner_A07 {
    public static void main(String[] args) throws IOException, InvalidPathException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        Files.walkFileTree(Paths.get("/path/to/start/from"),
                AttributeMask.include(FileAttributes.of(StandardFileAttributes.isDirectory)),
                10,
                new FileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        if (matcher.matches(file.getFileName())) {
                            System.out.println("Found file: " + file);
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public void encounteredException(Path dir, IOException e) throws IOException {
                        System.out.println("Exception encountered: " + e.getMessage());
                    }
                });
    }
}