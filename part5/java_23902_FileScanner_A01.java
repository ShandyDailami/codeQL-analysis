import java.io.File;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Files;
import java.nio.file.FileVisitResult;
import java.nio.file.PathMatcher;

public class java_23902_FileScanner_A01 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");

        FileVisitor<Path> visitor = new FileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (matcher.matches(file.getFileName())) {
                    // The file should not be accessed
                    System.out.println("File " + file.getFileName() + " is not accessible due to access control");
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("Error accessing file " + file.getFileName());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        };

        try (FileScanner<Path> scanner = Files.newScanner(Paths.get("."))) {
            scanner.iterateFiles(50, FileVisitOption.FOLLOW_LINKS, visitor);
        }
    }
}