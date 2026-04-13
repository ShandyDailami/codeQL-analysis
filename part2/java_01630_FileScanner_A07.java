import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_01630_FileScanner_A07 {

    public static void main(String[] args) {
        PathMatcher<? super Path> matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path file : stream) {
                FileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                if (attrs.isReadable() && attrs.isWritable()) {
                    System.out.println("File: " + file.toString());
                    // Add your security-sensitive operations here.
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading directory: " + ex.getMessage());
        }
    }
}