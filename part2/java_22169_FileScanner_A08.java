import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class java_22169_FileScanner_A08 {

    public static void main(String[] args) {
        String dir = "your-directory-path-here";
        printFilesInDirectory(dir);
    }

    public static void printFilesInDirectory(String dir) {
        try (
            Path path = FileSystems.getDefault().getPath(dir);
        ) {
            Files.walkFileTree(path, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file.toAbsolutePath());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}