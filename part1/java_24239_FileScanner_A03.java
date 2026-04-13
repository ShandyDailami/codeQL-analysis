import java.nio.file.*;
import java.util.*;
import java.nio.file.attribute.*;

public class java_24239_FileScanner_A03 {
    public static void main(String[] args) {
        Path startingDir = Paths.get("/path/to/directory");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(startingDir)) {
            for (Path path : stream) {
                if (Files.isRegularFile(path)) {
                    FileVisitResult result;
                    try {
                        // Using attribute to get file access time
                        result = Files.walkFileTree(path, new SimpleFileVisitor<>(),
                                                       AttributeMask.of(StandardFileAttributes.Basic.LAST_MODIFY_TIME));
                    } catch (IOException e) {
                        // Handle exception
                    }
                }
            }
        } catch (IOException e) {
            // Handle exception
        }
    }
}