import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnsupportedOperationException;

public class java_32971_FileScanner_A07 {
    private final File file;
    private final SecurityManager securityManager;

    public java_32971_FileScanner_A07(File file, SecurityManager securityManager) {
        this.file = file;
        this.securityManager = securityManager;
    }

    public void scan() {
        if (securityManager.checkPermission(new ReadPermission(file))) {
            // Scan file for content...
        } else {
            throw new UnsupportedOperationException("ReadPermission not granted");
        }
    }

    private static class ReadPermission extends Permission {
        private static final long serialVersionUID = 1;

        ReadPermission(String name) {
            super(name);
        }

        @Override
        public void initialize(String name) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean implies(Permission other) {
            return true;
        }
    }
}