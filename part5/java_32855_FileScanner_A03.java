import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_32855_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitResult result = super.visitFile(file, attrs);

                // Check if the file is a directory
                if (Files.isDirectory(file, LinkOption.NOFOLLOW_LINKS)) {
                    return FileVisitResult.CONTINUE;
                }

                // Check if the file is a regular file and contains sensitive information
                String content = Files.readAllLines(file).toString();
                if (content.contains("password") || content.contains("secret")) {
                    System.out.println("Found sensitive information in: " + file.toString());
                }

                return result;
            }
        });
    }
}