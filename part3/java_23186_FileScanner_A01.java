import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

public class java_23186_FileScanner_A01 {
    private static final Set<String> PERMISSION_SET = new HashSet<>(Set.of(
        "read", "write", "execute", "list", "delete", "create", "update", "move", "link", "own", "group"
    ));

    private static boolean hasPermission(String path) {
        return PERMISSION_SET.contains(Files.getFileAttributeView(Paths.get(path), FileAttributeView.class).readAttributes().isPermitted(BasicFileAttributes.UserPermission.GROUP_OWNER) ||
            Files.getFileAttributeView(Paths.get(path), FileAttributeView.class).readAttributes().isPermitted(BasicFileAttributes.UserPermission.OWNER);
    }

    public static void main(String[] args) {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startingDirectory, "*.java")) {
            for (Path path : directoryStream) {
                if (hasPermission(path.toString())) {
                    System.out.println("Permission granted for: " + path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}