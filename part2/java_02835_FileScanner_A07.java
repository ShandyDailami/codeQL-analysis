import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_02835_FileScanner_A07 {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(start)) {
            for (Path p : ds) {
                if (Files.isRegularFile(p) && Files.probeContentType(p).equals("text/plain")) {
                    BasicFileAttributes attrs = Files.readAttributes(p, BasicFileAttributes.class);
                    long size = attrs.size();
                    String name = p.getFileName().toString();
                    System.out.println(name + ": " + size + " bytes");
                }
            }
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex);
        }
    }
}