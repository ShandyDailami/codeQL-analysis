import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_24836_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "*.txt")) {
            for (Path path : dirs) {
                FileAttributes attrs = Files.readAttributes(path, FileAttributes.class);
                System.out.println(path);
                if (Files.isReadable(path) && Files.isWritable(path)) {
                    System.out.println("File is readable and writable");
                } else {
                    System.out.println("File is not readable or writable");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}