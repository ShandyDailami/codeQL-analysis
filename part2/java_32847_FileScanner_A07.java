import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.security.SecurityManager;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class java_32847_FileScanner_A07 {
    private static final String EXTENSION = ".txt";

    public static void main(String[] args) {
        File directory = new File(".");

        SecurityManager securityManager = new SecurityManager() {
            @Override
            public PermissionCollection getPermissions(ProtectionDomain domain) {
                return null;
            }

            @Override
            public boolean checkPermission(Permission perm) {
                return false;
            }
        };

        try {
            Scanner scanner = new Scanner(new FileReader("." + EXTENSION));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}