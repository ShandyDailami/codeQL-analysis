import java.nio.file.*;
import java.util.stream.*;

public class java_19821_FileScanner_A01 {
    public static void main(String[] args) {
        Path path = Paths.get("./src");
        try (Stream<Path> paths = Files.walk(path)) {
            paths.forEach(Main::print);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void print(Path path) {
        if (Files.isRegularFile(path)) {
            System.out.println(path.toString());
        }
    }
}