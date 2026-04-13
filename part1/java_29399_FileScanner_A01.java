import java.io.File;
import java.io.FilenameFilter;
import java.security.AccessControl;
import java.security.AccessControlProvider;
import java.security.AccessibleObjectException;
import java.security.GuardianPermission;
import java.security.PrivilegedAction;

public class java_29399_FileScanner_A01 {
    private final AccessControl accessControl;

    public java_29399_FileScanner_A01(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public void scanDirectory(String directoryPath, final String extension,
            final Runnable<? super File> action) {
        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + dir);
        }

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith("." + extension);
            }
        };

        try {
            accessControl.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    File[] files = dir.listFiles(filter);
                    for (File file : files) {
                        action.run(file);
                    }
                    return null;
                }
            });
        } catch (AccessibleObjectException | GuardianPermission.CollectionActionException | SecurityException e) {
            throw new RuntimeException(e);
        }
    }
}