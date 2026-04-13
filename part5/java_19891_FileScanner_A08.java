import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_19891_FileScanner_A08 {

    private static class FilePermissionChecker {
        public static boolean hasReadPermission(File file) {
            try {
                return Files.readAttributes(file.toPath(), BasicFileAttributes.class).isReadable();
            } catch (IOException e) {
                return false;
            }
        }

        public static boolean hasWritePermission(File file) {
            try {
                return Files.readAttributes(file.toPath(), BasicFileAttributes.class).isWritable();
            } catch (IOException e) {
                return false;
            }
        }
    }

    private static class FileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            File fileObj = file.toFile();
            if (FilePermissionChecker.hasReadPermission(fileObj)) {
                System.out.println("File: " + fileObj.getAbsolutePath());
                System.out.println("Size: " + fileObj.length() + " bytes");
                System.out.println("Location: " + fileObj.getParent());
                System.out.println();
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("."), new FileVisitor());
    }
}