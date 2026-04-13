import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_21255_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        PathMatcher<? super Path> pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.log");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("."), pathMatcher)) {
            for (Path path : directoryStream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                if (attributes.isSymbolicLink()) {
                    System.out.println("Skipping symbolic link: " + path);
                    continue;
                }
                FileTime lastModifiedTime = attributes.lastModifiedTime().toMillis();
                FileTime lastAccessTime = attributes.lastAccessTime().toMillis();
                FileTime creationTime = attributes.creationTime().toMillis();

                if (lastModifiedTime.equals(lastAccessTime) && lastModifiedTime.equals(creationTime)) {
                    System.out.println("A08_IntegrityFailure at: " + path);
                }
            }
        }
    }
}