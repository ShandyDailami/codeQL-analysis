import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

public class java_41979_FileScanner_A07 {
    private static final Set<String> AUTHORIZED_EXTENSIONS = new HashSet<>();
    private static final Set<String> AUTHORIZED_DIRECTORIES = new HashSet<>();

    static {
        AUTHORIZED_EXTENSIONS.add(".txt");
        AUTHORIZED_EXTENSIONS.add(".jpg");
        AUTHORIZED_EXTENSIONS.add(".png");

        AUTHORIZED_DIRECTORIES.add("/home/user");
        AUTHORIZED_DIRECTORIES.add("/home/admin");
    }

    public static void main(String[] args) throws IOException {
        Path startingPath = Paths.get("/home");
        scanDirectory(startingPath);
    }

    private static void scanDirectory(Path directory) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path path : stream) {
                if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    if (AUTHORIZED_DIRECTORIES.contains(path.toString())) {
                        scanDirectory(path);
                    }
                } else {
                    if (AUTHORIZED_EXTENSIONS.contains(Files.getFileExtension(path))) {
                        System.out.println("Authorized file: " + path);
                    }
                }
            }
        }
    }
}