import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_15519_FileScanner_A07 {

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                File fileEntry = file.toFile();
                if (fileEntry.isFile() && fileEntry.canRead()) {
                    System.out.println("Found file: " + fileEntry.getAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.err.println("Failed to access file: " + file);
                return FileVisitResult.CONTINUE;
            }
        };
        try {
            java.nio.file.Files.walkFileTree(rootDirectory.toPath(), fileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}