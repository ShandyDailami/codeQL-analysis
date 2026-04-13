import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_25213_FileScanner_A01 {

    public static void main(String[] args) {
        FileSystems.getDefault().supportedFileAttributeViews().forEach(view -> {
            try {
                File file = new File(".");
                Files.setAttribute(Paths.get(file.getAbsolutePath()), "dos:system_files", true, view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        FileSystem fs = FileSystems.getDefault();
        Path startingDir = fs.getPath(".");

        try (Stream<Path> stream = Files.walk(startingDir)) {
            stream.forEach(path -> {
                if (Files.isRegularFile(path)) {
                    System.out.println("Regular file: " + path);
                } else if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}