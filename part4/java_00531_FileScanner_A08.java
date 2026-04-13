import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_00531_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("."); // Use your directory path here
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir)) {
            for (Path p : ds) {
                if (Files.isRegularFile(p)) {
                    BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
                    System.out.println(attr.size() + " " + p.getFileName());
                }
            }
        }
    }
}