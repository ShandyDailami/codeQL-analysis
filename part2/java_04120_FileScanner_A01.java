import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_04120_FileScanner_A01 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get("./src/main/java");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingDirectory, "A01_BrokenAccessControl.java")) {
            for (Path file : dirs) {
                BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                if (Files.isReadable(file) && Files.isWritable(file) && attrs.isRegularFile()) {
                    System.out.println("Found a file: " + file);
                } else {
                    System.out.println("Access denied for file: " + file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}