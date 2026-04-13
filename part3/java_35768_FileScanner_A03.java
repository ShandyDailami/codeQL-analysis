import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_35768_FileScanner_A03 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.txt");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("."), matcher)) {
            for (Path path : directoryStream) {
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);

                System.out.println(path.toString() + " (in " + path.getFileSystem() + ") is a " +
                        (attrs.isRegularFile() ? "regular file" : (attrs.isDirectory() ? "directory" : "unknown")) +
                        (attrs.isSymbolicLink() ? " symbolic link" : "") +
                        (attrs.isOther() ? " other file" : ""));
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}