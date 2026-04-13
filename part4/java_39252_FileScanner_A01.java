import java.nio.file.*;
import java.util.stream.*;

public class java_39252_FileScanner_A01 {

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".").toAbsolutePath();
        String extension = "txt";

        try (Stream<Path> walk = Files.walk(startingDirectory)) {
            walk.filter(p -> p.getFileName().toString().endsWith(extension))
               .forEach(p -> System.out.println(p.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}