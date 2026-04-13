import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_29637_FileScanner_A01 {
    private String directory;

    public java_29637_FileScanner_A01(String directory) {
        this.directory = directory;
    }

    public void scan() {
        File root = new File(directory);
        if (root.exists() && root.isDirectory()) {
            try {
                Files.walkFileTree(root.toPath(), new MyFileVisitor(root.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class MyFileVisitor extends SimpleFileVisitor<Path> {
        private Path root;

        public java_29637_FileScanner_A01(Path root) {
            this.root = root;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            FileVisitorHelper.processFile(file.toFile());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            FileVisitorHelper.processFile(file.toFile());
            return FileVisitResult.CONTINUE;
        }
    }

    private static class FileVisitorHelper {
        private static void processFile(File file) {
            // Implement your security-sensitive operations here
            System.out.println("Processing file: " + file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        new FileScanner("/path/to/directory").scan();
    }
}