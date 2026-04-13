import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_15226_FileScanner_A01 {

    public static void main(String[] args) {
        Path startingPath = Paths.get(".").toAbsolutePath();
        try (Stream<Path> walk = Files.walk(startingPath)) {
            walk.filter(Files::isRegularFile)
                .map(Path::toAbsolutePath)
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}