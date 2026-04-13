import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_05892_FileScanner_A08 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("src"), matcher)) {
            for (Path path : dirs) {
                FileAttributes attributes = Files.readAttributes(path, FileAttributes.class);

                if (attributes.isReadable() && !attributes.isWritable()) {
                    System.out.println(path);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}