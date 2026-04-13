import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_40540_FileScanner_A08 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/A08_IntegrityFailure/*");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get("/path/to/directory"), matcher)) {
            for (Path dir : dirs) {
                File file = dir.toFile();
                if (file.isFile()) {
                    FileInfo fileInfo = Files.readAttributes(file.toPath(), FileAttributeView.functional(FileAttributes.class));
                    long integrityFailureTime = fileInfo.creationTime().toMillis();
                    long currentTime = System.currentTimeMillis();

                    if (currentTime - integrityFailureTime > 10000) { // if the file was modified more than 10 seconds ago
                        System.out.println("Integrity failure detected at: " + file.getAbsolutePath());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}