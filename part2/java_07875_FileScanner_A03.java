import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_07875_FileScanner_A03 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path start = Paths.get(".");
        try (Stream<Path> walk = Files.walk(start)) {
            for (Path p : walk.collect(Collectors.toList())) {
                if (Files.isDirectory(p) && !Paths.get(".").equals(p)) {
                    System.out.println("Directory: " + p);
                } else if (Files.isReadable(p)) {
                    System.out.println("Readable file: " + p);
                } else if (Files.isWritable(p)) {
                    System.out.println("Writable file: " + p);
                }
            }
        }
    }
}