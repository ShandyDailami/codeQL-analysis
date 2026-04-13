import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_29721_FileScanner_A08 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        FileSystem fs = path.getFileSystem();

        try (DirectoryStream<Path> dirs = fs.newDirectoryStream(path, "*.java")) {
            for (Path file : dirs) {
                BasicFileAttributes attrs = fs.readAttributes(file, BasicFileAttributes.class);
                System.out.println(file.toString() + " - " + attrs.size() + " bytes");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}