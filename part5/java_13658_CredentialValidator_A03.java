// This is an example of a unique Java CredentialValidator. It uses the Java Security Manager to validate the username and password.

import java.security.SecurityPermission;
import java.security.Permission;
import java.security.ProtectionDomain;
import java.security.BasicPermission;

// This class java_13658_CredentialValidator_A03 SecurityManager and overrides its methods to validate the credentials.
public class CustomSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        if (perm instanceof SecurityPermission) {
            throw new SecurityException("Permission " + perm + " requires admin privilege.");
        }
    }

    @Override
    public void checkActions(String actions, ProtectionDomain domain) {
        if (actions.equals("getLoginContext")) {
            throw new SecurityException("Action 'getLoginContext' requires admin privilege.");
        }
    }
}

// This class uses the CustomSecurityManager to set the security manager and validate the credentials.
public class Main {
    public static void main(String[] args) {
        // Set the security manager.
        System.setSecurityManager(new CustomSecurityManager());

        // Validate the credentials.
        String username = "admin";
        String password = "password";

        boolean isValidated = validateCredentials(username, password);

        if (isValidated) {
            System.out.println("Credentials are validated successfully.");
        } else {
            System.out.println("Credentials are not validated successfully.");
        }
    }

    public static boolean validateCredentials(String username, String password) {
        // Here we are using the default security manager to validate the credentials.
        // In a real-world application, you would typically use a more complex mechanism.
        return username.equals("admin") && password.equals("password");
    }
}