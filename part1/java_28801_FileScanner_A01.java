import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_28801_FileScanner_A01 {

    public static void main(String[] args) {
        File currentDir = new File(".");
        FileFilter filter = (File dir, String name) -> name.contains("password");

        try (Stream<Path> paths = Files.walk(Paths.get(currentDir.toURI()))) {
            paths.filter(p -> !Files.isDirectory(p))
                .map(Paths.get(currentDir.toURI()))
                .forEach(path -> {
                    try {
                        if (Files.exists(path) && Files.isRegularFile(path)) {
                            Files.lines(path)
                                .filter(line -> line.toLowerCase().contains("password"))
                                .forEach(System.out::println);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}