import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_32354_FileScanner_A01 {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(start, "*.{txt,html}")) {
            for (Path p : ds) {
                BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
                if (Files.isRegularFile(p)) {
                    System.out.printf("Regular File: %s%n", p);
                } else if (attr.isDirectory()) {
                    System.out.printf("Directory: %s%n", p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}