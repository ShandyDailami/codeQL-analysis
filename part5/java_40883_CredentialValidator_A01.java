import java.security.Permission;
import java.security.Permissions;
import java.security.ProtectionDomain;

public class java_40883_CredentialValidator_A01 {
    public static void main(String[] args) {
        try {
            checkPassword("test", "password");
            System.out.println("Access Granted!");
        } catch (Exception e) {
            System.out.println("Access Denied: " + e.getMessage());
        }
    }

    public static void checkPassword(String user, String password) throws Exception {
        // Create a new UserCredentials instance for the user
        UserCredentials uc = new UserCredentials(user, password);

        // Get the permissions for this user
        Permissions permissions = uc.getPermissions();

        // Check if the user has any permissions
        if (permissions.isEmpty()) {
            throw new Exception("No permissions for this user");
        }
    }
}