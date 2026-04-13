import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class java_37365_FileScanner_A08 {
    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^.+\\.(txt|docx|pdf|xlsx|html)$");
    private final SecurityManager securityManager;

    public java_37365_FileScanner_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public Set<File> scan(String directoryPath) throws SecurityException {
        if (securityManager.checkPermission(new Permission("fileSystemRead"))) {
            throw new SecurityException("Failed to access file system due to permission denied.");
        }

        Set<File> files = new HashSet<>();
        File directory = new File(directoryPath);
        populateFileSet(directory, files);
        return files;
    }

    private void populateFileSet(File directory, Set<File> files) {
        File[] allContents = directory.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                if (file.isDirectory()) {
                    populateFileSet(file, files);
                } else if (file.isFile() && validateFile(file)) {
                    files.add(file);
                }
            }
        }
    }

    private boolean validateFile(File file) {
        return VALID_EXTENSIONS.matcher(file.getName()).matches();
    }
}