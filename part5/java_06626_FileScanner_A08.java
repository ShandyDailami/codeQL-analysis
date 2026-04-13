import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_06626_FileScanner_A08 {

    private String fileExtension;

    public java_06626_FileScanner_A08(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void scanDirectory(String directoryPath) throws IOException {
        File rootDirectory = new File(directoryPath);
        if (!rootDirectory.exists() || !rootDirectory.isDirectory()) {
            throw new IllegalArgumentException("Not a valid directory path");
        }

        FileVisitor fileVisitor = new FileVisitorImpl();
        FileScanner fileScanner = new FileScanner(rootDirectory, fileVisitor, fileExtension);
        fileScanner.scan();
    }

    private class FileVisitorImpl extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            // Here we are simply returning FileVisitResult.CONTINUE to keep scanning
            // and checking for the file extension.
            // The actual implementation would depend on your specific needs for security-sensitive operations.
            if (!file.toString().endsWith(fileExtension)) {
                return FileVisitResult.CONTINUE;
            }

            // Perform security-sensitive operations here.
            // For example, check if the file is readable and not executable.

            // If the file is not executable, we can block it.
            if (!file.toFile().canRead()) {
                System.out.println("Blocked file: " + file.toFile().getAbsolutePath());
            }

            return FileVisitResult.CONTINUE;
        }
    }

    private class FileScanner {

        private File rootDirectory;
        private FileVisitor fileVisitor;
        private String fileExtension;

        public java_06626_FileScanner_A08(File rootDirectory, FileVisitor fileVisitor, String fileExtension) {
            this.rootDirectory = rootDirectory;
            this.fileVisitor = fileVisitor;
            this.fileExtension = fileExtension;
        }

        public void scan() throws IOException {
            java.nio.file.Files.walkFileTree(rootDirectory.toPath(), fileVisitor, java.nio.file.StandardFileAttributes.maskAllButCreateAndSetTimes());
        }
    }
}