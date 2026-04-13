import java.io.File;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class java_04804_FileScanner_A07 {

    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE_PATTERN = ".txt";

    public static void main(String[] args) {
        File file = new File(DIRECTORY);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setExecutable(false, false);

        PermissionCollection permissionCollection = file.getPermissions();
        ProtectionDomain protectionDomain = permissionCollection.getProtectionDomain();
        Permission[] permissions = permissionCollection.getPermissions();

        for (Permission permission : permissions) {
            System.out.println(permission.getClass().getName() + ": " + permission.getName());
        }
    }
}