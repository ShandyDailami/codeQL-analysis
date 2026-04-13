import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_41211_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path startPath = Paths.get("./src/main/java/");

        Files.walkFileTree(startPath, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".java")) {
                    System.out.println("File content: " + readFile(file));
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static String readFile(Path file) {
        try (Stream<String> stream = Files.lines(file)) {
            return stream.reduce("", String::concat);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}