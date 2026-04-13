import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_35305_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        FileFilter fileFilter = (File pathname) -> {
            boolean isDir = pathname.isDirectory();
            boolean isHidden = pathname.isHidden();

            // Security-sensitive operation: Check if file is executable
            if (isDir || isHidden) {
                return false;
            }

            // Security-sensitive operation: Check if file is writable
            try (Stream<Path> walk = Files.walk(Paths.get(pathname.getPath()))) {
                return walk.anyMatch(p -> p.toString().endsWith(".txt"));
            }
        };

        File[] hiddenFiles = directory.listFiles(fileFilter);

        for (File file : hiddenFiles) {
            System.out.println("Found file: " + file.getAbsolutePath());
        }
    }
}