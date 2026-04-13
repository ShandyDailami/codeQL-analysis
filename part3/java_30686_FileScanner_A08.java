import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_30686_FileScanner_A08 {

    public static void main(String[] args) {
        String dirPath = "src/main/resources";
        File file = new File(dirPath);
        try (Stream<Path> paths = Files.walk(Paths.get(dirPath))) {
            paths.forEach(path -> {
                if (Files.isRegularFile(path) && path.toString().endsWith(".txt")) {
                    try {
                        String content = new String(Files.readAllBytes(path));
                        System.out.println(content);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}