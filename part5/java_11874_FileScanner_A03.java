import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class java_11874_FileScanner_A03 {

    private static final String[] INPUT_DIRS = new String[] {
        System.getProperty("user.home") + "/input",
        System.getProperty("user.home") + "/output"
    };

    private static final String[] OUTPUT_DIRS = new String[] {
        System.getProperty("user.home") + "/safe_input",
        System.getProperty("user.home") + "/safe_output"
    };

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < INPUT_DIRS.length; i++) {
            Files.createDirectories(Paths.get(INPUT_DIRS[i]));
            Files.createDirectories(Paths.get(OUTPUT_DIRS[i]));

            try (Stream<Path> stream = Files.find(
                    Paths.get(INPUT_DIRS[i]),
                    1,
                    (path, basicFileAttributes) -> true)) {
                stream.forEach(path -> {
                    if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                        try {
                            Files.copy(path, Paths.get(OUTPUT_DIRS[i]).resolve(path.relativize(Paths.get(INPUT_DIRS[i]))),
                                    StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}