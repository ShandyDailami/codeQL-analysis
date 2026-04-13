import java.io.File;
import java.security.AccessControlException;
import java.security.Action;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;

public class java_34306_FileScanner_A01 {

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        scanDirectory(currentDir);
    }

    private static void scanDirectory(String directory) {
        File file = new File(directory);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    // Recursive call for directories
                    scanDirectory(f.getPath());
                } else if (f.isFile() && f.getName().endsWith(".txt")) {
                    // Security-sensitive operation
                    try {
                        secureAccess(new AccessControlAction() {
                            @Override
                            public void run() throws AccessControlException {
                                System.out.println("Scanning file: " + f.getPath());
                            }
                        });
                    } catch (AccessControlException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // Security-sensitive operation that modifies a file
    private static void secureAccess(AccessControlAction action) throws AccessControlException {
        action.run();
        // Add additional security-sensitive operations here
    }

    private interface AccessControlAction extends Action {
        @Override
        default void run() throws AccessControlException {
            throw new UnsupportedOperationException();
        }
    }

    private static class UnsupportedOperationException extends AccessControlException {
        UnsupportedOperationException() {
            super("Unsupported operation");
        }
    }
}