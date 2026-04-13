import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.SecurityManager;
import java.security.Permission;
import java.util.Scanner;

public class java_03415_FileScanner_A03 {
    private static final String FILE_PATH = "src/main/resources/file.txt";

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                // This method can be overridden to prevent a particular permission
            }

            @Override
            public void checkAccess(java.lang.reflect.MethodPermission perm) {
                // This method can be overridden to prevent a particular method
            }
        };

        // Set the security manager
        System.setSecurityManager(securityManager);

        try (Scanner scanner = new Scanner(new FileReader(new File(FILE_PATH)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}