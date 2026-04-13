import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_27393_FileScanner_A03 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt,log}");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("/path/to/directory"))) {
            for (Path path : directoryStream) {
                if (matcher.matches(path)) {
                    BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                    if (attributes.isRegularFile()) {
                        FileTimeAccessTimeAccessor accessor = new FileTimeAccessTimeAccessor();
                        FileTime fileTime = accessor.getFileTime(path, null);
                        System.out.printf("File %s is %s%n", path, fileTime.compareTo(Files.getLastModifiedTime(path)) < 0 ? "recently" : "very recently");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}