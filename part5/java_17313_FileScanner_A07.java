import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_17313_FileScanner_A07 {
    public static void main(String[] args) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.setPermission(new Permission("file:"), new PrivilegedAction<Void>() {
                public Void run() {
                    File file = new File("./");
                    File[] hiddenFiles = file.listFiles((dir, name) -> name.startsWith("."));
                    for (File f : hiddenFiles) {
                        System.out.println(f.getAbsolutePath());
                    }
                    return null;
                }
            });
        }
    }
}