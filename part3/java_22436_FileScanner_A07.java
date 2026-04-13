import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_22436_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher<? super Path> matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("/path/to/dir"))) {
            for (Path path : directoryStream) {
                if (matcher.matches(path.getFileName())) {
                    BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                    if (attributes.isRegularFile() && !attributes.isWritable()) {
                        System.out.println("File: " + path);
                        // Add your authentication code here
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}