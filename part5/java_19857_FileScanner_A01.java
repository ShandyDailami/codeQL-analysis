import java.nio.file.*;
import java.util.stream.*;

public class java_19857_FileScanner_A01 {

    public static void main(String[] args) {
        Path start = Paths.get(".");
        try (Stream<Path> walk = Files.walk(start)) {
            walk.filter(path -> path.getFileName().toString().equals("target.txt"))
               .forEach(Main::printPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPath(Path path) {
        System.out.println(path.toString());
    }
}