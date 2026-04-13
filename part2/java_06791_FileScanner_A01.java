import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.AttributeView;

public class java_06791_FileScanner_A01 {

    private String sourceDirectory;
    private String destinationDirectory;

    public java_06791_FileScanner_A01(String sourceDirectory, String destinationDirectory) {
        this.sourceDirectory = sourceDirectory;
        this.destinationDirectory = destinationDirectory;
    }

    public void scan() {
        try {
            Files.walkFileTree(Paths.get(sourceDirectory), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String targetFilePath = destinationDirectory + File.separator + file.getFileName().toString();
                    Files.copy(file, Paths.get(targetFilePath), StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("/path/to/source/directory", "/path/to/destination/directory");
        scanner.scan();
    }
}