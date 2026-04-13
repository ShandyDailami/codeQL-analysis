import java.nio.file.*;
import java.util.*;

public class java_34772_FileScanner_A01 {
    public static void main(String[] args) {
        Path startingPath = Paths.get(".").toAbsolutePath();
        scanDirectory(startingPath);
    }

    private static void scanDirectory(Path path) {
        try (Stream<Path> stream = Files.newDirectoryStream(path)) {
            List<Path> fileList = stream.collect(Collectors.toList());
            for (Path file : fileList) {
                if (Files.isDirectory(file)) {
                    scanDirectory(file);
                } else {
                    System.out.println(file.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}