import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_33605_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");

        try (Stream<Path> paths = Files.walk(start)) {
            paths.forEach(Main::print);
        }

        System.out.println("Done");
    }

    private static void print(Path path) {
        if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("Directory: " + path);
        } else {
            System.out.println("File: " + path);
        }
    }
}