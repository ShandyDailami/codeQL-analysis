import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.Subject;

public class java_02061_FileScanner_A01 {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public boolean checkAccess(Subject subject, Object object) throws AccessControlException {
                if (subject.getPrincipal().getName().equals("admin")) {
                    return true;
                } else {
                    throw new AccessDeniedException("Access denied!");
                }
            }
        };

        FileScanner fileScanner = new FileScanner(securityManager) {
            @Override
            public File[] scan(String path, String pattern) throws FileNotFoundException {
                return File.listRoots();
            }
        };

        try {
            File[] roots = fileScanner.scan(".", "*");
            for (File root : roots) {
                System.out.println("Root: " + root.getAbsolutePath());
            }
        } catch (AccessControlException e) {
            System.out.println("Access denied: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}