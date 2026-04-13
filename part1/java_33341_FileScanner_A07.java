import java.nio.file.*;
import java.util.stream.Stream;

public class java_33341_FileScanner_A07 {

    public static void main(String[] args) throws Exception {
        Path startingDir = Paths.get(".");
        String targetDir = "A07_AuthFailure";
        String extension = ".txt";

        findFiles(startingDir, targetDir, extension);
    }

    private static void findFiles(Path startingDir, String targetDir, String extension) throws Exception {
        try (Stream<Path> paths = Files.walk(startingDir)) {
            paths.forEach(path -> {
                if (Files.isRegularFile(path) && path.toString().endsWith(extension)) {
                    if (path.toString().contains(targetDir)) {
                        System.out.println("File: " + path.toString() + " contains target dir.");
                    } else {
                        System.out.println("File: " + path.toString() + " does not contain target dir.");
                    }
                }
            });
        }
    }
}