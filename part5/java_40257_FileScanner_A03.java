import java.nio.file.*;
import java.nio.file.attribute.*;

import java.io.*;

public class java_40257_FileScanner_A03 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");
        try (DirectoryStream<Path> files = Files.newDirectoryStream(Paths.get("/path/to/directory"))) {
            for (Path path : files) {
                if (matcher.matches(path.toString())) {
                    FileSystem fs = FileSystems.newFileSystem(path, null);
                    try (DirectoryStream<Path> subFiles = fs.newDirectoryStream(path, "glob:**/*.java")) {
                        for (Path subPath : subFiles) {
                            FileAttributes attrs = fs.readAttributes(subPath, BasicFileAttributes.class);
                            System.out.println(attrs.creationTime() + "\t" + attrs.lastModifiedTime() + "\t" + attrs.size() + "\t" + subPath);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}