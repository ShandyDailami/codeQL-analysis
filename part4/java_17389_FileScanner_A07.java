import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_17389_FileScanner_A07 {

    private static void printPath(Path path) {
        System.out.println("File Name: " + path.getFileName());
    }

    private static void printAttributes(BasicFileAttributes attrs) throws IOException {
        System.out.println("File Size: " + attrs.size());
        System.out.println("Last Modified: " + attrs.lastModifiedTime().toMillis());
    }

    private static void printPermission(FileSystem fileSystem, Path path) {
        try {
            FileAttributes fileAttributes = fileSystem.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Permissions: " + fileAttributes.permissions());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").normalize();
        try {
            Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    printPath(file);
                    printAttributes(attrs);
                    printPermission(Files.getFileSystem(file), file);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}