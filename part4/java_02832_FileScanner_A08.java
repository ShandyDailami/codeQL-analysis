import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_02832_FileScanner_A08 {
    private static class Finder extends SimpleFileVisitor<Path> {
        private String extension;
        private boolean found;

        Finder(String extension) {
            this.extension = extension;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(extension)) {
                found = true;
                System.out.println("Found file: " + file);
                return FileVisitResult.TERMINATE;
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        String directory = "/path/to/directory"; // Your directory here
        String extension = ".txt"; // The extension of the files you are looking for

        File directoryFile = new File(directory);

        if (directoryFile.exists() && directoryFile.isDirectory()) {
            Finder finder = new Finder(extension);
            finder.visit(directoryFile.toPath());
            if (!finder.found) {
                System.out.println("No file found with extension: " + extension);
            }
        } else {
            System.out.println("Not a valid directory");
        }
    }
}