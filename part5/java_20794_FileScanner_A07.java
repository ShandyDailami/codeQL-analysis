import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_20794_FileScanner_A07 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("/path/to/directory"))) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                    long modTime = attributes.creationTime().toMillis();
                    if (modTime < (System.currentTimeMillis() - 60000)) { // 60 seconds
                        System.out.println("Auth failure detected in file: " + path);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}