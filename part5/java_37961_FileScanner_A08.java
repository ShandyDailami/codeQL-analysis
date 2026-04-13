import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_37961_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        try (Stream<Path> walk = Files.walk(start)) {
            walk.forEach(FileScanner::<Path>fileInfo);
        }
    }

    private static void <T>fileInfo(T t, Path p) {
        if (Files.isRegularFile(p)) {
            System.out.println("File: " + p.toString());
        } else if (Files.isDirectory(p)) {
            System.out.println("Directory: " + p.toString());
        }
    }
}