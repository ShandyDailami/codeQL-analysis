import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_19299_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("."); // replace with your directory
        try (Stream<Path> paths = Files.walk(startingDirectory)) {
            paths.forEach(path -> {
                try {
                    FileTime accessTime = Files.getLastModifiedTime(path);
                    FileTime modificationTime = Files.getLastModifiedTime(path);
                    FileTime changeTime = Files.getLastModifiedTime(path);
                    if (!Files.isExecutable(path)) {
                        System.out.println("Access time: " + accessTime);
                        System.out.println("Modification time: " + modificationTime);
                        System.out.println("Change time: " + changeTime);
                        System.out.println("File: " + path.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}