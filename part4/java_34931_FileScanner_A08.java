import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class java_34931_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        String dirPath = "src"; // Change this to your directory
        countJavaFiles(dirPath);
    }

    private static void countJavaFiles(String dirPath) throws IOException {
        try (Stream<Path> paths = Files.walk(Path.of(dirPath))) {
            long count = paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .count();

            System.out.println("Number of .java files: " + count);
        }
    }
}