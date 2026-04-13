import java.io.File;
import java.io.FilenameFilter;
import java.security.AccessControlException;
import java.security.AccessibleObjectException;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.Arrays;
import java.util.Scanner;

public class java_02120_FileScanner_A01 {
    public static void main(String[] args) {
        File dir = new File(".");
        String[] files = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        Arrays.sort(files);

        SecurityManager sm = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) throws AccessibleObjectException {
                throw new AccessControlException("BrokenAccessControlException");
            }

            @Override
            public void checkAccess(java.security.Principal principal) throws AccessControlException {
                throw new AccessControlException("BrokenAccessControlException");
            }
        };
        System.setSecurityManager(sm);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a filename: ");
        String filename = scanner.nextLine();
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("Found the file: " + file.getPath());
        } else {
            System.out.println("File not found!");
        }
    }
}