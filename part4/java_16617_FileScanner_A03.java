import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class java_16617_FileScanner_A03 {

    private static final Set<String> EXTENSIONS = new HashSet<>();

    static {
        EXTENSIONS.add(".txt");
        EXTENSIONS.add(".csv");
        EXTENSIONS.add(".log");
        // add more extensions here
    }

    public static void main(String[] args) {
        String dirPath = args.length > 0 ? args[0] : ".";

        try (Stream<Path> paths = FileSystems.getDefault().getDirectoryStream(new File(dirPath), ".*\\.java")) {
            paths.forEach(path -> {
                if (path.toString().endsWith(".java")) {
                    System.out.println("Found Java file: " + path.toString());
                }
            });
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}