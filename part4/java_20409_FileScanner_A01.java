import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class java_20409_FileScanner_A01 {

    private static final String SOURCE_DIRECTORY = "source";
    private static final String TARGET_DIRECTORY = "target";

    public static void main(String[] args) {
        File sourceDirectory = new File(SOURCE_DIRECTORY);
        File targetDirectory = new File(TARGET_DIRECTORY);

        if (!targetDirectory.exists()) {
            targetDirectory.mkdir();
        }

        try (Stream<Path> paths = Files.walk(sourceDirectory.toPath())) {
            paths.forEach(path -> {
                if (Files.isRegularFile(path)) {
                    Path targetPath = targetDirectory.toPath().resolve(path.getFileName());
                    Files.copy(path, targetPath, StandardCopyOption.REPLACE);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}