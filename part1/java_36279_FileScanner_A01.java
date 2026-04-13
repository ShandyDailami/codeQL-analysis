import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_36279_FileScanner_A01 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("src/main/java"))) {
            for (Path path : directoryStream) {
                if (matcher.matches(path.getFileName())) {
                    FileAttributes attributes = Files.readAttributes(path, FileAttributes.class);
                    if (attributes.isReadable() || attributes.isWritable()) {
                        System.out.println("Found a file: " + path);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}