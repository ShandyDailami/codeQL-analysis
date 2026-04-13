import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_07182_FileScanner_A01 {
    private static final PathMatcher<Path> matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

    public static void main(String... args) throws IOException {
        Path startingDirectory = Paths.get("src");
        scanDirectory(startingDirectory);
    }

    private static void scanDirectory(Path dir) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, matcher)) {
            for (Path file : stream) {
                if (Files.isReadable(file)) {
                    BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                    long modTime = attrs.lastModifiedTime().toMillis();
                    long createTime = attrs.creationTime().toMillis();
                    long accessTime = attrs.lastAccessTime().toMillis();
                    System.out.println(file +
                            " Last modified: " + new Date(modTime) +
                            " Created: " + new Date(createTime) +
                            " Last accessed: " + new Date(accessTime));
                } else {
                    System.out.println("Can't read " + file);
                }
            }
        }

        for (Path file : dir.getFileSystem().list(dir)) {
            if (Files.isDirectory(file)) {
                scanDirectory(file);
            }
        }
    }
}