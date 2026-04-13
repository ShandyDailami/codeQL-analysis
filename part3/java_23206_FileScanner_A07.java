import java.io.File;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_23206_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/path/to/directory"))) {
            for (Path path : stream) {
                if (Files.isReadable(path)) {
                    Attribute<BasicFileAttributes> attr = FileSystems.getFileAttributeView(path, BasicFileAttributes.class);
                    BasicFileAttributes attributes = attr.readAttributes();
                    if (attributes.isReadable()) {
                        if (matcher.matches(path.getFileName())) {
                            System.out.println(path.toString());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}