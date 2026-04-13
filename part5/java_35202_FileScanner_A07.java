import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_35202_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
            for (Path p : ds) {
                if (Files.isRegularFile(p)) {
                    BasicFileAttributes attrs = Files.readAttributes(p, BasicFileAttributes.class);
                    long time = attrs.creationTime().toMillis();
                    long size = Files.size(p);
                    System.out.println(p + " [" + time + ", " + size + "]");
                }
            }
        }
    }
}