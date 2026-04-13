import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_03340_FileScanner_A01 {

    public static class FileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("File: " + file.toString());
            System.out.println("Content: " + new String(Files.readAllBytes(file)));
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println("Failed to visit file: " + file);
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java FileScanner directory");
            return;
        }

        File directory = new File(args[0]);
        if (!directory.exists()) {
            System.err.println("Directory does not exist");
            return;
        }

        try {
            Files.walkFileTree(directory.toPath(), new FileVisitor());
        } catch (IOException e) {
            System.err.println("Failed to walk the directory tree");
        }
    }
}