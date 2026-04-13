import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_03686_FileScanner_A03 {
    public static void main(String[] args) throws IOException, SecurityException {
        SecurityManager securityManager = new SecurityManager();
        FileVisitor<Path> visitor = new FileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isHidden(file)) {
                    return FileVisitResult.CONTINUE;
                }
                if (file.getFileName().toString().endsWith(".class")) {
                    return FileVisitResult.CONTINUE;
                }
                long size = Files.size(file);
                String name = file.getFileName().toString();
                System.out.println(String.format("%-20s %10d", name, size));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println("Failed to access file: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                String name = dir.getFileName().toString();
                System.out.println(String.format("%-20s", name));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        };

        FileSystem fs = FileSystems.newFileSystem(Paths.get("."), securityManager);
        try (FileScanner<Path> scanner = fs.newFileScanner(Paths.get("."), visitor, FileVisitOption.FOLLOW_LINKS)) {
            scanner.visitFirst();
        }
    }
}