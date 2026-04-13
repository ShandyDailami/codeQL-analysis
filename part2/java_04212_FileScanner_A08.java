import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_04212_FileScanner_A08 {

    public static void main(String[] args) {
        Path start = Paths.get(".");
        try (Stream<Path> walk = Files.walk(start)) {
            boolean validDir = true;
            for (Path p : walk) {
                if (Files.isDirectory(p, LinkOption.NOFOLLOW_LINKS)) {
                    if (p.equals(start)) {
                        validDir = false;
                        break;
                    }
                    try (Stream<Path> files = Files.list(p)) {
                        for (Path file : files) {
                            BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                            System.out.printf("%s  %d%n", file.getName(), attrs.size());
                        }
                    }
                }
            }
            if (!validDir) {
                System.out.printf("Directory not found%n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}