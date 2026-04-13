import java.lang.reflect.Field;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_08945_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("src/main/java");
        FileSystem fs = startingDirectory.getFileSystem();
        Field fileSystem = FileSystems.class.getDeclaredField("default");
        fileSystem.setAccessible(true);
        FileSystemProvider provider = (FileSystemProvider) fileSystem.get(fs);
        try (Stream<Path> paths = provider.readDirectory(fs.getPath(startingDirectory.toString()))) {
            paths.forEach(path -> {
                if (Files.isReadable(path)) {
                    System.out.println("Found readable file: " + path);
                } else {
                    System.out.println("Found non-readable file: " + path);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}