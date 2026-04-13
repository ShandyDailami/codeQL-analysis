import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class java_02670_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new Permission("foo"));
            sm.checkPermission(new Permission("bar"));
        }
        try {
            Iterator<File> it = file.listFiles().iterator();
            while (it.hasNext()) {
                File f = it.next();
                if (f.getName().equals("..") || f.getName().equals(".")) {
                    it.remove();
                }
            }
        } catch (SecurityException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}