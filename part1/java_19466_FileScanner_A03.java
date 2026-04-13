import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;

public class java_19466_FileScanner_A03 {
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        try {
            Files.walkFileTree(rootDirectory.toPath(), new SimpleFileVisitor<>(), 10, FileVisitOption.FOLLOW_LINKS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processDirectory(Path dir) {
        try {
            Files.walk(dir, 10)
                .filter(path -> !Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS))
                .forEach(FileScanner::processFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processFile(Path path) {
        File file = path.toFile();
        if (file.isFile() && isSensitiveOperation(file)) {
            try {
                Files.move(path, path.getParent().resolve(OUTPUT_FILE), StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isSensitiveOperation(File file) {
        // Implement your own logic to check if the file is sensitive.
        // This is a placeholder, replace with your own logic.
        return false;
    }
}