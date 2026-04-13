import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class java_36863_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";  // replace with your directory path
        try {
            Files.walk(Paths.get(directoryPath))
                .filter(path -> Files.isRegularFile(path))
                .forEach(BrokenAccessControlExample::printFileDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFileDetails(Path path) {
        try {
            if (Files.isReadable(path)) {
                List<String> permissions = Files.getPermissionStrings(path);
                if (permissions.contains("read")) {
                    System.out.printf("File: %s, Permissions: %s%n", path, String.join(", ", permissions));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}