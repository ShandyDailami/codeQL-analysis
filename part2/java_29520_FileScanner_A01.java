import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_29520_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        // Start from the current directory
        Path start = Paths.get(".");

        // Recursive scan
        Files.walkFileTree(start, (dir, name) -> Files.isRegularFile(name))
            .forEach(FileScanner::printFile);
    }

    private static void printFile(Path path) {
        System.out.println(path.toString());
    }
}