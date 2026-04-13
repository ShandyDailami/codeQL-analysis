import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_26456_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".").toAbsolutePath();
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingPath, "*.txt")) {
            for (Path path : dirs) {
                FileTime lastModified = Files.getLastModifiedTime(path);
                FileAttributes attrs = Files.readAttributes(path, FileAttributes.class);
                long size = Files.size(path);
                System.out.println(path.getFileName() + " - Last Modified: " + lastModified +
                        ", Size: " + size + " bytes");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}