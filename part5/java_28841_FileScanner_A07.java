import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_28841_FileScanner_A07 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/path/to/dir"), matcher)) {
            for (Path path : stream) {
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println("File Name: " + path.getFileName());
                System.out.println("Directory Name: " + path.getParent().getFileName());
                System.out.println("File Size: " + attrs.size());
                System.out.println("File Creation Time: " + attrs.creationTime());
                System.out.println("File Last Modified Time: " + attrs.lastModifiedTime());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}