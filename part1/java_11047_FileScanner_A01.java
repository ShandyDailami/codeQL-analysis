import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class java_11047_FileScanner_A01 {
    private List<Path> directories;

    public java_11047_FileScanner_A01(List<Path> directories) {
        this.directories = directories;
    }

    public void scan(String filename) throws IOException {
        Path currentFile = Paths.get(".");
        if (directories != null) {
            for (Path dir : directories) {
                if (Files.exists(dir.resolve(currentFile))) {
                    scanRecursive(dir.resolve(currentFile), filename);
                }
            }
        }
        scanRecursive(currentFile, filename);
    }

    private void scanRecursive(Path path, String filename) throws IOException {
        try (Stream<Path> walk = Files.walk(path)) {
            List<Path> matches = walk
                    .filter(p -> p.getFileName().toString().equals(filename))
                    .collect(Collectors.toList());
            for (Path match : matches) {
                if (Files.isDirectory(match)) {
                    scanRecursive(match, filename);
                } else {
                    System.out.println(match.toString());
                }
            }
        }
    }
}