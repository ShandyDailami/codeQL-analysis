import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_32215_FileScanner_A08 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("src/main/java"))) {
            for (Path path : directoryStream) {
                if (matcher.matches(path)) {
                    FileAttributes attributes = Files.readAttributes(path, FileAttributes.class);
                    if (attributes.isRegularFile()) {
                        System.out.println(path.toString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}