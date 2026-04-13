import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.BasicPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.SecurityManager;
import java.security.UnavailableException;
import java.util.Scanner;

public class java_04687_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a SecurityManager to provide a PermissionCollection
        SecurityManager sm = new SecurityManager() {
            @Override
            public PermissionCollection getPermissions(SecurityContext context) {
                return new PermissionCollection() {
                    @Override
                    public boolean implies(Permission p) {
                        // Only return true for BasicPermission
                        return p instanceof BasicPermission;
                    }
                };
            }
        };

        // Provide the SecurityManager to the Java Runtime Environment (JRE)
        System.setSecurityManager(sm);

        String path = "path_to_your_file"; // Replace with your file path
        File file = new File(path);

        try (Scanner scanner = new Scanner(new FileReader(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        } catch (UnavailableException e) {
            System.out.println("Permission denied: " + file.getPath());
        }
    }
}