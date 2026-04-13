import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.atomic.AtomicInteger;

public class java_20719_FileScanner_A08 {
    private static AtomicInteger fileCount = new AtomicInteger(0);
    private static AtomicInteger lineCount = new AtomicInteger(0);

    public static void main(String[] args) {
        Path start = Paths.get(".");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(start, "*.java")) {
            for (Path dir : dirs) {
                Files.readAllLines(dir).forEach(line -> {
                    if (line.trim().startsWith("class")) {
                        fileCount.incrementAndGet();
                    } else if (!line.trim().startsWith("//")) {
                        lineCount.incrementAndGet();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Number of files: " + fileCount.get());
        System.out.println("Number of lines: " + lineCount.get());
    }
}