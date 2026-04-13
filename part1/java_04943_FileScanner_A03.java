import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_04943_FileScanner_A03 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(startingDirectory, "*.java")) {
            for (Path file : dirStream) {
                FileAttributeView attrView = Files.getFileAttributeView(file, false);
                BasicFileAttributes attr = attrView.readAttributes();
                // Security-sensitive operations related to A03_Injection:
                if (attr.isSymbolicLink() || attr.size() == 0) {
                    // Do nothing or log for security
                } else if (!attr.isReadable() || !attr.isWritable()) {
                    // Change file permissions to make it more secure
                    Files.setPermissions(file, Files.setPermissions(file, Files.getPosixFilePermissions(file)
                            .stream().map(SecurityContext::getPermissions).flatMap(Set::stream).collect(Collectors.toSet()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}