import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.BasicFileAttributes;

public class java_22043_FileScanner_A07 {

    public static void main(String[] args) {
        Path path = Paths.get(".");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path, "*.java")) {
            for (Path p : ds) {
                BasicFileAttributes attrs = Files.readAttributes(p, BasicFileAttributes.class);
                long size = Files.size(p);
                System.out.println(p + " (" + attrs.size() + " bytes)");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}