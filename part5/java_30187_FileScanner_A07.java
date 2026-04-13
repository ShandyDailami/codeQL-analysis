import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_30187_FileScanner_A07 {
    public static void main(String[] args) {
        Path startingDir = Paths.get(".");
        BasicFileAttributes startingAttributes = FileAttributes.readAttributes(startingDir,
                StandardFileAttributes.class);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(startingDir,
                "*.java")) {
            for (Path path : stream) {
                BasicFileAttributes attrs = FileAttributes.readAttributes(path,
                        StandardFileAttributes.class);
                if (attrs.isDirectory() || attrs.size() == 0) {
                    continue;
                }
                if (path.toString().endsWith("AuthFailure.java")) {
                    System.out.println("Found AuthFailure file: " + path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}