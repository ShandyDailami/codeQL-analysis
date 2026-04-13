import java.io.File;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.GuardedBy;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public class java_00328_FileScanner_A01 {
    private static final List<String> files = new ArrayList<>();

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        scanDirectory(directory);
        files.forEach(System.out::println);
    }

    private static void scanDirectory(String directory) {
        File file = new File(directory);
        if (!file.exists()) {
            throw new IllegalArgumentException("Directory " + directory + " does not exist");
        }
        if (!file.canRead()) {
            throw new AccessControlException("Access to " + directory + " is denied");
        }
        try {
            java.nio.file.Files.newFileScan().
                    addListener((file, fileAttributes) -> {
                        System.out.println("File: " + file.getAbsolutePath());
                        return file;
                    }, files::add).
                    scan();
        } catch (AccessDeniedException | SecurityException e) {
            throw new AccessControlException("Access to " + directory + " is denied", e);
        }
    }
}