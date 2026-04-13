import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_34918_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        BasicFileAttributes attributes;

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                attributes = Files.readAttributes(file, BasicFileAttributes.class);
                if (attributes.isDirectory()) {
                    System.out.println("Directory: " + file);
                } else if (attributes.isRegularFile()) {
                    System.out.println("Regular File: " + file);
                } else if (attributes.isSymbolicLink()) {
                    System.out.println("Symbolic Link: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}