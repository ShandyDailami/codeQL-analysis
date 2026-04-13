import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_24502_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get("src/main/java");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.java")) {
            for (Path path : dirs) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println(path.toAbsolutePath());
                System.out.println("Creation time: " + attributes.creationTime());
                System.out.println("Last modified time: " + attributes.lastModifiedTime());
                System.out.println("Size: " + attributes.size());
            }
        }
    }
}