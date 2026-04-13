import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_13420_FileScanner_A03 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.ext");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("/path/to/directory"), matcher)) {
            for (Path path : dirs) {
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                if (Files.isReadable(path)) {
                    System.out.println("File: " + path + " has attributes: " + attrs);
                } else {
                    System.out.println("File: " + path + " is not readable");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}