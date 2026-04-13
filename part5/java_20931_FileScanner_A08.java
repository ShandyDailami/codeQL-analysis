import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_20931_FileScanner_A08 {

    private File file;

    public java_20931_FileScanner_A08(String path) {
        this.file = new File(path);
    }

    public void scan() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.doPrivileged(new FileScanPrivilegedAction());
        } else {
            System.out.println("No SecurityManager found. Not scanning files.");
        }
    }

    private class FileScanPrivilegedAction implements PrivilegedAction<Void> {
        public Void run() {
            if (file.exists()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (f.isDirectory()) {
                        System.out.println("Directory: " + f.getAbsolutePath());
                        new FileScanner(f.getAbsolutePath()).scan();
                    } else {
                        System.out.println("File: " + f.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("File not found: " + file.getAbsolutePath());
            }
            return null;
        }
    }

    public static void main(String[] args) {
        new FileScanner("/path/to/start/scanning").scan();
    }
}