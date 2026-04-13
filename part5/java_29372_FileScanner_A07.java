import java.io.File;
import java.io.FileNotFoundException;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnrecognizedSecurityException;
import java.util.Scanner;

public class java_29372_FileScanner_A07 {
    private static final String TARGET_FILE_PATH = "/path/to/target/file";

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public boolean checkPermission(Permission perm) {
                // Check if the permission is related to authentication failure
                if ("A07_AuthFailure".equals(perm.getName())) {
                    // If it is, deny the permission
                    return false;
                }
                return true;
            }

            @Override
            public boolean checkDelete(String file) throws UnrecognizedSecurityException {
                // Check if the file is a directory
                File fileObj = new File(file);
                if (fileObj.isDirectory()) {
                    return false;
                }
                return true;
            }
        };

        // Set the security manager
        Security.setSecurityManager(securityManager);

        File targetFile = new File(TARGET_FILE_PATH);
        try (Scanner scanner = new Scanner(targetFile)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Target file not found.");
        }
    }
}