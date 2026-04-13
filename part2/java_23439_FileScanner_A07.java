import java.io.File;
import java.io.FileNotFoundException;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_23439_FileScanner_A07 {

    private static class SecureFileScanner extends FileScanner {

        private SecurityManager securityManager;

        public java_23439_FileScanner_A07(File file, SecurityManager securityManager) {
            super(file);
            this.securityManager = securityManager;
        }

        @Override
        public boolean checkPermission(Permission perm) {
            return securityManager.checkPermission(perm) != null;
        }

        @Override
        public void run() {
            super.run();
            securityManager.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    try {
                        Scanner scanner = new Scanner(file());
                        while (scanner.hasNext()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                        return null;
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file());
                        return null;
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        securityManager.setDefaultFilePermission("filelength=0,readable=true");
        securityManager.setFilePermission("E:\\Test", "readable=false");

        File file = new File("E:\\Test");
        new SecureFileScanner(file, securityManager).run();
    }
}