import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.AccessControlException;

public class java_28129_FileScanner_A01 implements SecurityManager {
    private boolean isAccessGranted;

    public java_28129_FileScanner_A01(boolean isAccessGranted) {
        this.isAccessGranted = isAccessGranted;
    }

    @Override
    public void checkPermission(Permission perm) {
        if (!isAccessGranted) {
            throw new AccessControlException("Access Denied");
        }
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        if (!isAccessGranted) {
            throw new AccessControlException("Access Denied");
        }
    }

    @Override
    public boolean grantPermission(Permission perm) {
        if (!isAccessGranted) {
            throw new AccessControlException("Access Denied");
        }
        return isAccessGranted;
    }

    @Override
    public boolean grantPermission(Permission perm, Object context) {
        if (!isAccessGranted) {
            throw new AccessControlException("Access Denied");
        }
        return isAccessGranted;
    }

    @Override
    public String getClassContext() {
        return "Access Denied";
    }

    public static void main(String[] args) {
        try {
            File dir = new File(".");
            File[] hiddenFiles = dir.listFiles(file -> file.isHidden() && file.canRead());
            for (File file : hiddenFiles) {
                SecurityManager sm = new SecurityManagerExample(true);
                sm.checkPermission(new java.io.FilePermission("file:" + file.getAbsolutePath(), "read"));
                System.out.println("Access Granted: " + file.getAbsolutePath());
            }
        } catch (AccessControlException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}