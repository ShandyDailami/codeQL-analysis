import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_32903_FileScanner_A07 {

    private final String directory;

    public java_32903_FileScanner_A07(String directory) {
        this.directory = directory;
    }

    public void scan() {
        File dir = new File(directory);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory: " + directory);
            return;
        }

        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            paths.filter(path -> !Files.isDirectory(path))
                .forEach(path -> readFileAndDisplayContents(path.toAbsolutePath().toString()));
        } catch (IOException e) {
            System.out.println("Error reading files from directory: " + directory);
            e.printStackTrace();
        }
    }

    private void readFileAndDisplayContents(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading file: " + path);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AuthFailureFileScanner("./test").scan();
    }
}