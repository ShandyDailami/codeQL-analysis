import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_40523_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(start, "*.java")) {
            for (Path p : ds) {
                BasicFileAttributes attrs;
                try (BufferedReader br = Files.newBufferedReader(p)) {
                    attrs = Files.readAttributes(p, BasicFileAttributes.class);
                    System.out.println(attrs);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}