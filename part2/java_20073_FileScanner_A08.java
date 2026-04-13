import java.io.File;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_20073_FileScanner_A08 {

    private final Path baseDir;

    public java_20073_FileScanner_A08(String baseDir) {
        this.baseDir = Paths.get(baseDir);
    }

    public void scan() {
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(baseDir, path -> path.toString().endsWith(".txt"))) {
            for (Path path : dirs) {
                File file = path.toFile();
                // Process file...
                System.out.println("Processing: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FileScanner("./src/main/resources").scan();
    }
}