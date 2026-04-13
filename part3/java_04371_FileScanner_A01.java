import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class java_04371_FileScanner_A01 {
    private static final Set<String> SPECIAL_FILE_EXTENSIONS = Set.of(".exe", ".dll", ".sys", ".bin", ".scr", ".mscb");
    private static final Set<String> SPECIAL_DIR_NAMES = Set.of(".", "..", "~", "#", "$", "%", "&", "*", "(", ")", "+", "-", "=", "@", "?", "<", ">", " ", ":", ";", "\"", "'", "\\", "/");

    public static void main(String[] args) throws IOException {
        String rootDirectory = args.length > 0 ? args[0] : "/";

        Files.walk(Path.of(rootDirectory))
            .filter(path -> Files.isRegularFile(path))
            .filter(path -> isSecuritySensitive(path))
            .map(path -> path.toAbsolutePath().toString())
            .forEach(BrokenAccessControlScanner::writeAccessDeniedMessage);
    }

    private static boolean isSecuritySensitive(Path path) {
        String fileName = path.getFileName().toString();
        return SPECIAL_FILE_EXTENSIONS.contains(fileName.substring(fileName.lastIndexOf(".") + 1))
            || SPECIAL_DIR_NAMES.contains(fileName)
            || path.getParent().toString().contains("\\system32")
            || path.getParent().toString().contains("\\sys32");
    }

    private static void writeAccessDeniedMessage(String path) {
        try {
            Files.writeString(Path.of(path), "Access to file " + path + " has been denied by the system.", StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}